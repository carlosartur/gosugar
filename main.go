package main

import (
    "fmt"
    "github.com/antlr4-go/antlr/v4"
    "gopp-parser/parser" // Substitua pelo caminho do parser gerado
	"gopp-parser/transpiler"
)

func main() {
	input := antlr.NewInputStream(`
		class Employee use Person, Printable {
			Salary float64

			func Constructor(name string, age int, id int64, salary float64) {
				this.Salary = salary
			}

			func GetSalary() float64 {
				return this.Salary
			}

			func SetSalary(salary float64) {
				this.Salary = salary
			}

			func Print() {
				fmt.Printf("Name: %s\n", this.Name)
				fmt.Printf("Age: %d\n", this.Age)
				fmt.Printf("ID: %d\n", this.ID)
				fmt.Printf("Salary: %.2f\n", this.Salary)
			}
		}
	`)

	lexer := parser.NewGoPlusLexer(input)
	stream := antlr.NewCommonTokenStream(lexer, 0)
	p := parser.NewGoPlusParser(stream)
	p.BuildParseTrees = true
	
	listener := &transpiler.TranspilerListener{}
	antlr.ParseTreeWalkerDefault.Walk(listener, p.Program()) // Registra o listener

	
	tree := p.Program() // Substitua pelo nó inicial correto da gramática
	antlr.ParseTreeWalkerDefault.Walk(listener, tree)

	// fmt.Println(tree.ToStringTree(nil, p))
	
	fmt.Println("---- GO CODE ----")
	fmt.Println(listener.GoCode())
	fmt.Println("---- END GO CODE ----")
}