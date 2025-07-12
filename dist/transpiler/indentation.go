package transpiler

import "strings"

type Indentation int32


func (this *Indentation) Increment() {
    *this++

}

func (this *Indentation) Decrement() {
    if *this>0 {
        *this--
    }

}

func (this *Indentation) String() string {
    return strings.Repeat(" ",int(*this)*4)

}

