package main

import (
	"flag"
	"fmt"
	"io"
	"io/fs"
	"os"
	"path/filepath"
	"strings"

	"gopp-parser/config"
	"gopp-parser/parser"
	"gopp-parser/transpiler"

	"github.com/antlr4-go/antlr/v4"
)

// isDirectory checks if the given path is a directory.
//
// Parameters:
// - path: The path to check if it is a directory.
//
// Returns true if the path is a directory, otherwise returns false.
func isDirectory(path string) bool {
	info, err := os.Stat(path)
	if err != nil {
		return false
	}
	return info.IsDir()
}

// transpiller reads a source file, parses its content, and writes the
// transpiled Go code to the specified output directory. It maintains
// the directory structure relative to the base path.
//
// Parameters:
// - filePath: The path to the source file to be transpiled.
// - basePath: The base path to maintain directory structure for output.
// - outputDir: The directory where the transpiled Go file will be written.
//
// Returns an error if any file operations fail or if there are issues
// during parsing or writing the output file.
func transpiller(filePath, basePath, outputDir string) error {

	content, err := os.ReadFile(filePath)
	if err != nil {
		return fmt.Errorf("error reading file %s: %v", filePath, err)
	}

	input := antlr.NewInputStream(string(content))

	lexer := parser.NewGoSugarLexer(input)
	stream := antlr.NewCommonTokenStream(lexer, 0)
	p := parser.NewGoSugarParser(stream)
	p.BuildParseTrees = true

	listener := &transpiler.TranspilerListener{}
	tree := p.Program()
	antlr.ParseTreeWalkerDefault.Walk(listener, tree)

	relPath, err := filepath.Rel(basePath, filepath.Dir(filePath))
	if err != nil {
		return fmt.Errorf("error getting relative path: %v", err)
	}

	outputPath := filepath.Join(outputDir, relPath)
	if err := os.MkdirAll(outputPath, os.ModePerm); err != nil {
		return fmt.Errorf("error creating output directory %s: %v", outputPath, err)
	}

	outputFilePath := filepath.Join(outputPath, filepath.Base(filePath[:len(filePath)-len(filepath.Ext(filePath))]+".go"))

	// fmt.Printf("code structure: %s\n", listener.ProcessedRulesList.ToString())

	err = os.WriteFile(outputFilePath, []byte(listener.GoCode()), 0644)
	if err != nil {
		return fmt.Errorf("error writing to file %s: %v", outputFilePath, err)
	}

	fmt.Printf("Transpiled: %s -> %s\n", filePath, outputFilePath)
	return nil
}

// readEnvFile reads the .gosugar.env file from the given directory and returns its
// contents. If the file does not exist, it returns nil and no error.
func readEnvFile(path string) ([]byte, error) {
	envFilePath := filepath.Join(path, ".gosugar.env")
	if _, err := os.Stat(envFilePath); os.IsNotExist(err) {
		return nil, nil
	}

	content, err := os.ReadFile(envFilePath)
	if err != nil {
		return nil, fmt.Errorf("error reading .gosugar.env file in %s: %v", path, err)
	}

	return content, nil
}

// processDirectory walks through the given directory and its subdirectories,
// transpiling all .gosu files into .go files and copying all other files into
// the output directory. It first cleans the output directory, then creates it
// again with the correct permissions.
func processDirectory(path string) error {
	content, enverr := readEnvFile(path)
	if enverr == nil && content != nil {
		config.CurrentConfigs.SetEnvContent(string(content))
	}

	outputDir := filepath.Join(path, config.CurrentConfigs.Get("TRANSPILE_PATH"))
	if outputDir == "" {
		outputDir = filepath.Join(path, "dist")
	}

	err := os.RemoveAll(outputDir)
	if err != nil {
		return fmt.Errorf("error cleaning output directory %s: %v", outputDir, err)
	}

	err = os.MkdirAll(outputDir, os.ModePerm)
	if err != nil {
		return fmt.Errorf("error creating output directory %s: %v", outputDir, err)
	}

	err = filepath.WalkDir(path, func(filePath string, d fs.DirEntry, err error) error {
		if err != nil {
			return err
		}

		if !d.IsDir() {
			if filepath.Ext(filePath) == ".gosu" {
				fmt.Println("\nTranspiling:", filePath)
				err = transpiller(filePath, path, outputDir)
				if err != nil {
					return err
				}
			} else {
				relPath, err := filepath.Rel(path, filePath)
				if err != nil {
					return fmt.Errorf("error getting relative path: %v", err)
				}

				if strings.HasPrefix(relPath, ".git") || strings.HasPrefix(relPath, outputDir) {
					return nil
				}

				destPath := filepath.Join(outputDir, relPath)
				if err := os.MkdirAll(filepath.Dir(destPath), os.ModePerm); err != nil {
					return fmt.Errorf("error creating output directory %s: %v", filepath.Dir(destPath), err)
				}
				err = copyFile(filePath, destPath)
				if err != nil {
					return fmt.Errorf("error copying file %s to %s: %v", filePath, destPath, err)
				}
			}
		}

		return nil
	})

	return err
}

// copyFile copies a file from src to dst.
func copyFile(src, dst string) error {
	sourceFile, err := os.Open(src)
	if err != nil {
		return err
	}
	defer sourceFile.Close()

	destFile, err := os.Create(dst)
	if err != nil {
		return err
	}
	defer destFile.Close()

	_, err = io.Copy(destFile, sourceFile)
	if err != nil {
		return err
	}

	return nil
}

// main processes all .gosu files in the directory given in the --path
// parameter and outputs the corresponding .go files in the same
// directory.
func main() {
	path := flag.String("path", "", "Path to the directory containing .gosu files")
	flag.Parse()

	if *path == "" {
		fmt.Println("Please provide a path to the directory with parameter --path")
		return
	}

	if !isDirectory(*path) {
		fmt.Printf("Invalid directory: %s\n", *path)
		return
	}

	err := processDirectory(*path)
	if err != nil {
		fmt.Printf("Error processing directory: %v\n", err)
	}
}
