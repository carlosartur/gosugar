module gosugar-parser

go 1.22

toolchain go1.23.6

require (
	github.com/antlr4-go/antlr/v4 v4.13.1
	gosugar-parser/transpiler v0.0.0-00010101000000-000000000000
	gosugar-parser/config v0.0.0-00010101000000-000000000000
)

require golang.org/x/exp v0.0.0-20240506185415-9bf2ced13842 // indirect

replace gosugar-parser/transpiler => ./transpiler

replace gosugar-parser/config => ./config
