package main

import (
    "fmt"
	"flag"
	"io/fs"
	"io/ioutil"
	"os"
	"path/filepath"

    "github.com/antlr4-go/antlr/v4"
    "gopp-parser/parser"
	"gopp-parser/transpiler"
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
func transpiller(filePath string, content string) error {
	input := antlr.NewInputStream(content)

	// Configuração do lexer e parser
	lexer := parser.NewGoPlusLexer(input)
	stream := antlr.NewCommonTokenStream(lexer, 0)
	p := parser.NewGoPlusParser(stream)
	p.BuildParseTrees = true

	// Listener para processar a árvore de análise
	listener := &transpiler.TranspilerListener{}
	tree := p.Program()
	antlr.ParseTreeWalkerDefault.Walk(listener, tree)

	// Gerar arquivo de saída .go
	outputFilePath := filePath[:len(filePath)-len(filepath.Ext(filePath))] + ".go"
	err := ioutil.WriteFile(outputFilePath, []byte(listener.GoCode()), 0644)
	if err != nil {
		return fmt.Errorf("error writing to file %s: %v", outputFilePath, err)
	}

	fmt.Printf("Transpiled: %s -> %s\n", filePath, outputFilePath)
	return nil
}

// Função para percorrer recursivamente os arquivos com extensão .gopp
func processDirectory(path string) error {
	err := filepath.WalkDir(path, func(filePath string, d fs.DirEntry, err error) error {
		if err != nil {
			return err
		}

		// Verificar se o arquivo tem a extensão .gopp
		if !d.IsDir() && filepath.Ext(filePath) == ".gopp" {
			content, err := ioutil.ReadFile(filePath)
			if err != nil {
				return fmt.Errorf("error reading file %s: %v", filePath, err)
			}

			// Chamar a função transpiller
			err = transpiller(filePath, string(content))
			if err != nil {
				return err
			}
		}

		return nil
	})

	return err
}

func main() {
	// Definir a flag de entrada
	path := flag.String("path", "", "Path to the directory containing .gopp files")
	flag.Parse()

	// Validar o caminho
	if *path == "" {
		fmt.Println("Please provide a path to the directory with parameter --path")
		return
	}

	if !isDirectory(*path) {
		fmt.Printf("Invalid directory: %s\n", *path)
		return
	}

	// Processar os arquivos no diretório
	err := processDirectory(*path)
	if err != nil {
		fmt.Printf("Error processing directory: %v\n", err)
	}
}
