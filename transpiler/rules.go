package transpiler

import (
	"fmt"
	"reflect"
	"strings"

	"github.com/antlr4-go/antlr/v4"
)

type ProcessedRule struct {
	Text string
	Line int
	Type string
}

type ProcessedRules struct {
	rules []ProcessedRule
}

func (pr *ProcessedRules) AddRule(ctx antlr.ParserRuleContext) {
	line := ctx.GetStart().GetLine()
	text := ctx.GetText()
	typ := reflect.TypeOf(ctx).String()

	pr.rules = append(pr.rules, ProcessedRule{Text: text, Line: line, Type: typ})
}

func (pr *ProcessedRules) IsDuplicate(ctx antlr.ParserRuleContext, typ ...string) bool {
	line := ctx.GetStart().GetLine()
	text := ctx.GetText()

	for _, rule := range pr.rules {
		if rule.Line == line && strings.Contains(rule.Text, text) {
			for _, t := range typ {
				if rule.Type == t {
					return true
				}
			}
		}
	}
	return false
}

func (pr *ProcessedRules) ToString() string {
	var builder strings.Builder

	builder.WriteString("[Rules]\n")

	for _, rule := range pr.rules {
		builder.WriteString("    ")
		builder.WriteString(fmt.Sprintf("%d", rule.Line))
		builder.WriteString("\n        Type: ")
		builder.WriteString(fmt.Sprintf("%s", rule.Type))
		builder.WriteString("\n        Text: ")
		builder.WriteString(rule.Text)
		builder.WriteString("\n")
	}

	return builder.String()
}
