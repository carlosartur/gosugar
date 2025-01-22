module gopp-parser

go 1.18

require github.com/antlr4-go/antlr/v4 v4.13.1

require (
	golang.org/x/exp v0.0.0-20240506185415-9bf2ced13842 // indirect
	gopp-parser/transpiler v0.0.0-00010101000000-000000000000 // indirect
)

replace gopp-parser/transpiler => ./transpiler
