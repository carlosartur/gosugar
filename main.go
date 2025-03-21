package main

import (
	"flag"
	"fmt"
	"io"
	"io/fs"
	"os"
	"path/filepath"

	"gopp-parser/config"
	"gopp-parser/parser"
	"gopp-parser/transpiler"

	"github.com/antlr4-go/antlr/v4"
)

// Função para validar se um caminho é um diretório
func isDirectory(path string) bool {
	info, err := os.Stat(path)
	if err != nil {
		return false
	}
	return info.IsDir()
}

// Função transpiller que converte o código e escreve em um arquivo .go
func transpiller(filePath, basePath, outputDir string) error {

	content, err := os.ReadFile(filePath)
	if err != nil {
		return fmt.Errorf("error reading file %s: %v", filePath, err)
	}

	input := antlr.NewInputStream(string(content))

	// Configuração do lexer e parser
	lexer := parser.NewGoSugarLexer(input)
	stream := antlr.NewCommonTokenStream(lexer, 0)
	p := parser.NewGoSugarParser(stream)
	p.BuildParseTrees = true

	// Listener para processar a árvore de análise
	listener := &transpiler.TranspilerListener{}
	tree := p.Program()
	antlr.ParseTreeWalkerDefault.Walk(listener, tree)

	// Preservar a estrutura de diretórios no outputDir
	relPath, err := filepath.Rel(basePath, filepath.Dir(filePath))
	if err != nil {
		return fmt.Errorf("error getting relative path: %v", err)
	}

	outputPath := filepath.Join(outputDir, relPath)
	if err := os.MkdirAll(outputPath, os.ModePerm); err != nil {
		return fmt.Errorf("error creating output directory %s: %v", outputPath, err)
	}

	// Criar caminho do arquivo de saída
	outputFilePath := filepath.Join(outputPath, filepath.Base(filePath[:len(filePath)-len(filepath.Ext(filePath))]+".go"))

	// Escrever o arquivo
	err = os.WriteFile(outputFilePath, []byte(listener.GoCode()), 0644)
	if err != nil {
		return fmt.Errorf("error writing to file %s: %v", outputFilePath, err)
	}

	fmt.Printf("Transpiled: %s -> %s\n", filePath, outputFilePath)
	return nil
}

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

func processDirectory(path string) error {
	content, enverr := readEnvFile(path)
	if enverr == nil && content != nil {
		config.CurrentConfigs.SetEnvContent(string(content))
	}

	outputDir := filepath.Join(path, config.CurrentConfigs.Get("TRANSPILE_PATH"))
	if outputDir == "" {
		outputDir = filepath.Join(path, "dist")
	}

	err := filepath.WalkDir(path, func(filePath string, d fs.DirEntry, err error) error {
		if err != nil {
			return err
		}

		if !d.IsDir() {
			if filepath.Ext(filePath) == ".gosu" {
				fmt.Println("Transpiling:", filePath)
				err = transpiller(filePath, path, outputDir)
				if err != nil {
					return err
				}
			} else {
				// Copiar arquivos que não são .gosu para o diretório de saída
				relPath, err := filepath.Rel(path, filePath)
				if err != nil {
					return fmt.Errorf("error getting relative path: %v", err)
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
