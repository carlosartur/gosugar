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

func (ProcessedRules) Constructor() *ProcessedRules {
    this := new(ProcessedRules)
    return this
}


func (ProcessedRule) Constructor(text string, line int, typ string) *ProcessedRule {
    this := new(ProcessedRule)
    this.Text = text
    this.Line = line
    this.Type = typ
    return this

}

func (this *ProcessedRules) AddRule(ctx antlr.ParserRuleContext) {
    line := ctx.GetStart().GetLine()
    text := ctx.GetText()
    typ := reflect.TypeOf(ctx).String()
    newRule := ProcessedRule{}.Constructor(text, line, typ)    
    this.rules = append(this.rules,*newRule)

}

func (this *ProcessedRules) IsDuplicate(ctx antlr.ParserRuleContext, typ ...string) bool {
    line := ctx.GetStart().GetLine()
    text := ctx.GetText()
    for _, rule := range this.rules {
        if rule.Line==line&&strings.Contains(rule.Text,text) {
            for _, t := range typ {
                if rule.Type==t {
                    return true
                }
            }
        }
    }
    return false

}

func (this *ProcessedRules) ToString() string {
    var builder strings.Builder
    builder.WriteString("[Rules]\n")
    for _, rule := range this.rules {
        builder.WriteString("    ")
        builder.WriteString(fmt.Sprintf("%d",rule.Line))
        builder.WriteString("\n        Type: ")
        builder.WriteString(fmt.Sprintf("%s",rule.Type))
        builder.WriteString("\n        Text: ")
        builder.WriteString(rule.Text)
        builder.WriteString("\n")
    }
    return builder.String()

}

