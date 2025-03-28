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
5. `create` keyword (like `new` in other languages)
6. `foreach` loop (simpler iteration over collections)
7. Static Methods
8. Automatic Constructors (reducing boilerplate)
9. `this` keyword (inside methods for clarity)
10. Extending Built-in Types (`as` keyword)
11. Simulated Inheritance via Composition (`use` keyword)
12. Modern Lambda/Anonymous Function Syntax

## Why Use `Constructor` as a Method?

In GoSugar, constructors are implemented as methods rather than special functions. This approach has several advantages:

1. **Avoids Occupying a Name**: The name `NewClass` remains available for users to define their own factory functions without conflicts.
2. **Prevents Arbitrary Renaming**: The transpiler does not need to rename `Constructor` to `NewClass`, ensuring clarity in the code.
3. **Consistent Naming**: All constructors use `Constructor`, avoiding name duplication issues within the same package.
4. **Explicitness**: Unlike implicit constructors in some languages, GoSugar keeps object creation explicit, adhering to Go's philosophy of clarity.

## Code Examples

### 1. Classes, Properties, and Methods (`this` keyword)

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

### 2. Mandatory Interfaces (`must` keyword)

```go
interface IPerson {
    GetName() string
}

// If class Person doesn't implement method GetName returning a string,
// the transpiler will throw an error, requiring it to be implemented
class Person must IPerson {
    // Attribute
    Name string

    // Method
    func GetName() string {
        return this.Name
    }
}
```

### 3. Constructors and the `create` Keyword

```go
class Person {
    // Attribute
    Name string

    // Constructor method.
    // This initializes the object and returns it.
    func Constructor(name string) {
        this.Name = name
    }
}

// Main function
func main() {
    // 'create' calls the 'Constructor' method.
    // If the class has no 'Constructor' method, an empty constructor is generated.
    person := create Person("John")
    fmt.Println(person.GetName())
}
```

### 4. Foreach Loop

```go
func main() {
    nums := []int{10, 20, 30, 40}

    // 'foreach' simplifies Go's for-range loop.
    foreach nums as index, num {
        fmt.Printf("Index: %d, Value: %d\n", index, num)
    }

    // Key or index is optional.
    foreach nums as num {
        fmt.Printf("Value: %d\n", num)
    }
}
```

### 5. Static Methods

```go
class Person {
    Name string

    // Constructor method
    func Constructor(name string) {
        this.Name = name
    }

    // Static method
    static func SayHello(p Person) string {
        say := fmt.Sprintf("Hello, %s!", p.Name)
        fmt.Println(say)
        return say
    }
}

// Main function
func main() {
    person := create Person("John")

    // Static functions belong to the class, not instances.
    Person{}.SayHello(person)
}
```

### 6. Extending Built-in Types

```go
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
    fmt.Println(i)

    i.Increment()
    fmt.Println(i)

    i.Decrement()
    fmt.Println(i)
}
```

### 7. Simulated Inheritance via Composition

```go
class Person {
    Name string

    func GetName() string {
        return this.Name
    }
}

// Composition works like traits in PHP, mixins in Ruby, and protocol extensions in Swift.
class Employee use Person {
    Salary float64

    func Constructor(name string, salary float64) {
        this.Name = name
        this.Salary = salary
    }

    func GetSalary() float64 {
        return this.Salary
    }
}

// Main function
func main() {
    e := create Employee("John", 1234.56)
    fmt.Println(e.GetName())
    fmt.Println(e.GetSalary())
}
```

### 8. Lambda/Anonymous Functions

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

## Complete Example

```go
package main
import "fmt"

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

// Employee class using composition and implementing an interface
class Employee use Person, Printable must IPrintable {
    Salary float64

    func Constructor(name string, age int, id int64, salary float64) {
        this.Name = name
        this.Age = age
        this.Id = id
        this.Salary = salary
    }
}

// Main function
func main() {
    employee := create Employee("Carlos", 36, 1234, 10000.00)
    employee.Print()
}
```

## Why Choose GoSugar?

- Maintain Go’s performance while improving its syntax
- Write cleaner, more expressive code
- Fully compatible with Go – compiles to standard Go
- Reduce boilerplate, making development faster

Learn more: (repository link here)

