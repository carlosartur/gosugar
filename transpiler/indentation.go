package transpiler

import "strings"

type Indentation int32

func (i *Indentation) Increment() {
	*i++
}

func (i *Indentation) Decrement() {
	if *i > 0 {
		*i--
	}
}

func (i Indentation) String() string {
	return strings.Repeat(" ", int(i) * 4)
}

