# GoSugar – A Little Sugar for Go

GoSugar is a **dialect of Go** designed to enhance Go’s simplicity with powerful **object-oriented** features while maintaining full compatibility. It **transpiles to standard Go**, ensuring you can leverage GoSugar’s syntax improvements without sacrificing performance.

> **Disclaimer**: GoSugar is an independent project and is **not affiliated, associated, authorized, endorsed by, or in any way officially connected with the Go programming language or Google LLC**.

## Why GoSugar?

Go is a powerful language, but sometimes it lacks certain high-level features found in other languages. GoSugar introduces enhancements to make Go development more expressive and productive while keeping Go’s philosophy intact.

## Features Added to Go

GoSugar enhances Go by introducing:

1. Classes (`class` keyword)
2. Mandatory Interfaces (`must` keyword)
3. Methods 
4. Constructors (explicit and automatic)
5. `create` keyword (like new in other languages)
6. `foreach` loop (simpler iteration over collections)
7. Static Methods
8. Automatic Constructors (reducing boilerplate)
9. `this` keyword (inside methods for clarity)
10. Extending Built-in Types (`as` keyword)
11. Simulated Inheritance via Composition (`use` keyword)
12. Modern Lambda/Anonymous Function Syntax

## Code examples

1. Classes, properties/attributes and methods, this especial var use (features 1, 3 and 9 above)
```go
class Person {
    // Attribute
    Name string

    // Method
    func GetName() string {
        return this.Name
    }
}
```

2. Mandatory Interfaces (feature 2 above)

```go
interface IPerson {
    GetName() string
}

// If class Person don't implement method GetName returning a string,
// the transpiller will throw a error, asking to implement it
class Person must IPerson {
    // Attribute
    Name string

    // Method
    func GetName() string {
        return this.Name
    }
}
```

3. Constructors, create keyword (features 4, 8 and 5 above)

```go
class Person {
    // Attribute
    Name string

    // Constructor method. 
    // Creates 'this' object, execute the code inside the function,
    // and returns created object
    func Constructor(name string) {
        this.Name = name
    }

    // Method
    func GetName() string {
        return this.Name
    }
}

// Main function
func main() {
    // 'create' will call 'Constructor' function.
    // If class doesn't have a 'Constructor' method, the transpiller will create a empty constructor
    person := create Person("John")
    fmt.Println(person.GetName())
}
```

4. Foreach

```go
func main() {
    nums := []int{10, 20, 30, 40}

    // 'foreach' is an shortcut for for-range loop.
    foreach nums as index, num {
        fmt.Printf("Foreach with index and value \nIndex: %d, Value: %d\n", index, num)
    }

    // key or index is optional.
    foreach nums as num {
        fmt.Printf("Foreach with value only \nValue: %d\n", num)
    }
}
```

5. Static methods

```go
class Person {
    // Attribute
    Name string

    // Constructor method. 
    // Creates 'this' object, execute the code inside the function,
    // and returns created object
    func Constructor(name string) {
        this.Name = name
    }

    // Method
    static func SayHello(p Person) string {
        say := fmt.Sprintf("Hello, %s!", p.Name)
        fmt.Println(say)
        return say
    }
}

// Main function
func main() {
    person := create Person("John")

    // A static function creates a type function, not a object function,
    // so, you must call with ClassName{}.StaticFuncName()
    Person{}.SayHello(person)
}
```

6. Extending Built-in Types (feature 10 above)

```go
// Here, you can expand types that current exists
// 'Must interface' is still supported here, but composition is not supported because Go do not support it.
class MyInt as int32 {
    // Methods
    func Increment() {
        *this++
    }

    func Decrement() {
        if *this > 0 {
            *this--
        }
    }
}

// Main function
func main() {
    var i MyInt

    i = 0

    // Prints 0
    fmt.Println(i)

    // Increment i value to 1
    i.Increment()

    // Prints 1
    fmt.Println(i)

    // Decrement i value back to 0
    i.Decrement()

    // Prints 0, again
    fmt.Println(i)
}
```

7. Simulated Inheritance via Composition (feature 11 above)

```go
class Person {
    // Attribute
    Name string

    // Method
    func GetName() string {
        return this.Name
    }
}

// Here, composition happens.
// It works like traits from PHP and Rust, mixins from Ruby and Python,
// protocol extensions from Swift, default interface methods from C#,
// and interfaces with implementation from Kotlin.
//  
// IMPORTANT: Go does not support implicit upcasting of embedded types.  
// Unlike inheritance in object-oriented languages, embedding does not  
// make the outer struct a subtype of the embedded struct.  
// You must explicitly access the embedded field when passing it to functions.
class Employee use Person {
    Salary float64

    // Constructor method. 
    func Constructor(name string, salary float64) {
        this.Name = name
        this.Salary = salary
    }

    // Method
    func GetSalary() float64 {
        return this.Salary
    }
}

// Main function
func main() {

    e := create Employee("John", 1234.56)

    // Prints name of Employee
    fmt.Println(e.GetName())

    // Prints salary of Employee
    fmt.Println(e.GetSalary())
}
```

8. Lambda/Anonimous functions

```go
// Main function
func main() {

    // Function with parameter and return type
    exampleFn := (i int): int -> {
        fmt.Println(i)
        return i
    }

    exampleFn(1)

    // Function with no return type
    exampleFn = (i int) -> {
        fmt.Println(i)
    }

    exampleFn(1)

    // Function with no parameter and no return type
    exampleFn = () -> {
        fmt.Println("Print this message, and no more.")
    }

    exampleFn()
}
```

### Complete example code

```go
package main

import (
    "fmt"
)

// Interfaces
interface IPrintable {
    Print()
}

// Base Classes
class Person {
    Name string
    Age  int
    Id   int64
}

class Printable {
    func Print() {
        fmt.Printf("%v\n", this)
    }
}

// Employee class extending Person and Printable, implementing IPrintable
class Employee use Person, Printable must IPrintable {
    Salary float64

    // Constructor
    func Constructor(name string, age int, id int64, salary float64) {
        this.Name = name
        this.Age = age
        this.Id = id
        this.Salary = salary
    }

    func GetSalary() float64 {
        return this.Salary
    }

    func SetSalary(salary float64) *Employee {
        this.Salary = salary
        return this
    }

    func SumSalary(rise float64) (*Employee, float64) {
        this.Salary += rise
        return this, this.Salary
    }

    // Implementing Print method
    func Print() {
        fmt.Printf("Name: %s\n", this.Name)
        fmt.Printf("Age: %d\n", this.Age)
        fmt.Printf("ID: %d\n", this.Id)
        fmt.Printf("Salary: %.2f\n", this.Salary)
    }

    static func TestEmployee(e Employee) {
        fmt.Printf("Name: %s\n", e.Name)
        fmt.Printf("Age: %d\n", e.Age)
        fmt.Printf("ID: %d\n", e.Id)
        fmt.Printf("Salary: %.2f\n", e.Salary)
    }
}

// Another class implementing IPrintable
class Client must IPrintable {
    func Print() {
        fmt.Printf("Client")
    }
}

// Main function to test syntax
func main() {
    employee := create Employee("Carlos", 36, 1234, 10000.00)
    employee.Print()
    Employee{}.TestEmployee(employee)
}
```

## Why Choose GoSugar?
- Keep Go’s performance while improving its syntax
- Write cleaner, more expressive code
- Maintain Go compatibility – everything compiles to standard Go
- Reduce boilerplate, making development faster

Learn more: (repository link here)