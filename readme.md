# GoSugar – A Little Sugar for Go

GoSugar is a **dialect of Go** designed to enhance Go’s simplicity with powerful **object-oriented** features while maintaining full compatibility. It **transpiles to standard Go**, ensuring you can leverage GoSugar’s syntax improvements without sacrificing performance.

> **Disclaimer**: GoSugar is an independent project and is **not affiliated, associated, authorized, endorsed by, or in any way officially connected with the Go programming language or Google LLC**.

## Why GoSugar?

Go is a powerful language, but sometimes it lacks certain high-level features found in other languages. GoSugar introduces enhancements to make Go development more expressive and productive while keeping Go’s philosophy intact.

## Features Added to Go

GoSugar enhances Go by introducing:

1. Classes (<span class="keyword">class</span> keyword)
2. Mandatory Interfaces (<span class="keyword">must</span> keyword)
3. Methods 
4. Constructors (explicit and automatic)
5. <span class="keyword">create</span> keyword (like new in other languages)
6. <span class="keyword">foreach</span> loop (simpler iteration over collections)
7. <span class="keyword">static</span> Methods
8. Automatic Constructors (reducing boilerplate)
9. <span class="keyword">this</span> keyword (inside methods for clarity)
10. Extending Built-in Types (<span class="keyword">as</span> keyword)
11. Simulated Inheritance via Composition (<span class="keyword">use</span> keyword)
12. Modern Lambda/Anonymous Function Syntax

## Code examples

1. Classes, properties/attributes and methods, this especial var use (features 1, 3 and 9 above)
<pre>
<span class="keyword">class</span> <span class="class">Person</span> {
    <span class="comment">// Attribute</span>
    <span class="variable">Name</span> <span class="type">string</span>

    <span class="comment">// Method</span>
    <span class="func-keyword">func</span> <span class="function">GetName</span>() <span class="type">string</span> {
        <span class="keyword">return</span> <span class="this">this</span>.<span class="variable">Name</span>
    }
}
</pre>

2. Mandatory Interfaces (feature 2 above)

<pre>
<span class="keyword">interface</span> <span class="class">IPerson</span> {
    <span class="function">GetName</span>() <span class="type">string</span>
}

<span class="comment">// If class Person don't implement method GetName returning a string,
// the transpiller will throw a error, asking to implement it</span>
<span class="keyword">class</span> <span class="class">Person</span> <span class="keyword">must</span> <span class="class">IPerson</span> {
    <span class="comment">// Attribute</span>
    <span class="variable">Name</span> <span class="type">string</span>

    <span class="comment">// Method</span>
    <span class="func-keyword">func</span> <span class="function">GetName</span>() <span class="type">string</span> {
        <span class="keyword">return</span> <span class="this">this</span>.<span class="variable">Name</span>
    }
}
</pre>

3. Constructors, create keyword (features 4, 8 and 5 above)

<pre>
<span class="keyword">class</span> <span class="class">Person</span> {
    <span class="comment">// Attribute</span>
    <span class="variable">Name</span> <span class="type">string</span>

    <span class="comment">// Constructor method. 
    // Creates 'this' object, execute the code inside the function,
    // and returns created object</span>
    <span class="func-keyword">func</span> <span class="function">Constructor</span>(name <span class="type">string</span>) {
        <span class="this">this</span>.<span class="variable">Name</span> = name
    }

    <span class="comment">// Method</span>
    <span class="func-keyword">func</span> <span class="function">GetName</span>() <span class="type">string</span> {
        <span class="keyword">return</span> <span class="this">this</span>.<span class="variable">Name</span>
    }
}

<span class="comment">// Main function</span>
<span class="func-keyword">func</span> <span class="function">main</span>() {
    <span class="comment">// 'create' will call 'Constructor' function.
    // If class doesn't have a 'Constructor' method, the transpiller will create a empty constructor</span>
    person := <span class="keyword">create</span> Person(<span class="string">"John"</span>)
    fmt.Println(person.GetName())
}

</pre>

4. Foreach

<pre>
<span class="func-keyword">func</span> <span class="function">main</span>() {
    nums := []<span class="type">int</span>{10, 20, 30, 40}

    <span class="comment">// 'foreach' is an shortcut for for-range loop.</span>
    <span class="keyword">foreach</span> nums <span class="keyword">as</span> index, num {
        fmt.Printf(<span class="string">"Foreach with index and value \nIndex: %d, Value: %d\n"</span>, index, num)
    }

    <span class="comment">// key or index is optional.</span>
    <span class="keyword">foreach</span> nums <span class="keyword">as</span> num {
        fmt.Printf(<span class="string">"Foreach with value only \nValue: %d\n"</span>, num)
    }
}

</pre>

5. Static methods

<pre>
<span class="keyword">class</span> <span class="class">Person</span> {
    <span class="comment">// Attribute</span>
    <span class="variable">Name</span> <span class="type">string</span>

    <span class="comment">// Constructor method. 
    // Creates 'this' object, execute the code inside the function,
    // and returns created object</span>
    <span class="func-keyword">func</span> <span class="function">Constructor</span>(name <span class="type">string</span>) {
        <span class="this">this</span>.<span class="variable">Name</span> = name
    }

    <span class="comment">// Method</span>
    <span class="keyword">static</span> <span class="func-keyword">func</span> <span class="function">SayHello</span>(p <span class="type">Person</span>) <span class="type">string</span> {
        say := fmt.Sprintf(<span class="string">"Hello, %s!"</span>, p.Name)
        fmt.Println(say)
        <span class="keyword">return</span> <span class="variable">say</span>
    }
}

<span class="comment">// Main function</span>
<span class="func-keyword">func</span> <span class="function">main</span>() {
    person := <span class="keyword">create</span> Person(<span class="string">"John"</span>)

    <span class="comment">// A static function creates a type function, not a object function,
    // so, you must call with ClassName{}.StaticFuncName()</span>
    Person{}.SayHello(person)
}

</pre>

6. Extending Built-in Types (feature 10 above)

<pre>
<span class="comment">// Here, you can expand types that current exists
// 'Must interface' is still supported here, but composition is not supported because Go do not support it.</span>
<span class="keyword">class</span> <span class="class">MyInt</span> <span class="keyword">as</span> <span class="type">int32</span> {
    <span class="comment">// Methods</span>
    <span class="func-keyword">func</span> <span class="function">Increment</span>() {
        *<span class="this">this</span>++
    }

    <span class="func-keyword">func</span> <span class="function">Decrement</span>() {
        <span class="keyword">if</span> *<span class="this">this</span> > 0 {
            *<span class="this">this</span>--
        }
    }
}

<span class="comment">// Main function</span>
<span class="func-keyword">func</span> <span class="function">main</span>() {
    <span class="keyword">var</span> i <span class="type">MyInt</span>

    i = 0

    <span class="comment">// Prints 0</span>
    fmt.Println(i)

    <span class="comment">// Increment i value to 1</span>
    i.Increment()

    <span class="comment">// Prints 1</span>
    fmt.Println(i)

    <span class="comment">// Decrement i value back to 0</span>
    i.Decrement()

    <span class="comment">// Prints 0, again</span>
    fmt.Println(i)
}

</pre>

7. Simulated Inheritance via Composition (feature 11 above)

<pre>

<span class="keyword">class</span> <span class="class">Person</span> {
    <span class="comment">// Attribute</span>
    <span class="variable">Name</span> <span class="type">string</span>

    <span class="comment">// Method</span>
    <span class="func-keyword">func</span> <span class="function">GetName</span>() <span class="type">string</span> {
        <span class="keyword">return</span> <span class="this">this</span>.<span class="variable">Name</span>
    }
}

<span class="comment">// Here, composition happens.
// It works like traits from PHP and Rust, mixins from Ruby and Python,
// protocol extensions from Swift, default interface methods from C#,
// and interfaces with implementation from Kotlin.
//  
// IMPORTANT: Go does not support implicit upcasting of embedded types.  
// Unlike inheritance in object-oriented languages, embedding does not  
// make the outer struct a subtype of the embedded struct.  
// You must explicitly access the embedded field when passing it to functions.</span>
<span class="keyword">class</span> <span class="class">Employee</span> <span class="keyword">use</span> <span class="class">Person</span> {
    <span class="variable">Salary</span> <span class="type">float64</span>

    <span class="comment">// Constructor method. </span>
    <span class="func-keyword">func</span> <span class="function">Constructor</span>(name <span class="type">string</span>, salary <span class="type">float64</span>) {
        <span class="this">this</span>.<span class="variable">Name</span> = name
        <span class="this">this</span>.<span class="variable">Salary</span> = salary
    }

    <span class="comment">// Method</span>
    <span class="func-keyword">func</span> <span class="function">GetSalary</span>() <span class="type">float64</span> {
        <span class="keyword">return</span> <span class="this">this</span>.<span class="variable">Salary</span>
    }
}

<span class="comment">// Main function</span>
<span class="func-keyword">func</span> <span class="function">main</span>() {

    e := <span class="keyword">create</span> Employee(<span class="string">"John"</span>, 1234.56)

    <span class="comment">// Prints name of Employee</span>
    fmt.Println(e.GetName())

    <span class="comment">// Prints salary of Employee</span>
    fmt.Println(e.GetSalary())
}

</pre>

8. Lambda/Anonimous functions

<pre>
<span class="comment">// Main function</span>
<span class="func-keyword">func</span> <span class="function">main</span>() {

    <span class="comment">// Function with parameter and return type</span>
    exampleFn := (i <span class="type">int</span>): <span class="type">int</span> -> {
        fmt.Println(i)
        return i
    }

    exampleFn(1)

    <span class="comment">// Function with no return type</span>
    exampleFn = (i <span class="type">int</span>) -> {
        fmt.Println(i)
    }

    exampleFn(1)

    <span class="comment">// Function with no parameter and no return type</span>
    exampleFn = () -> {
        fmt.Println(<span class="string">"Print this message, and no more."</span>)
    }

    exampleFn()
}
</pre>

### Complete example code

<pre>
<span class="keyword">package</span> <span class="function">main</span>

<span class="keyword">import</span> (
    <span class="string">"fmt"</span>
)

<span class="comment">// Interfaces</span>
<span class="keyword">interface</span> <span class="class">IPrintable</span> {
    <span class="function">Print</span>()
}

<span class="comment">// Base Classes</span>
<span class="keyword">class</span> <span class="class">Person</span> {
    <span class="variable">Name</span> <span class="type">string</span>
    <span class="variable">Age</span>  <span class="type">int</span>
    <span class="variable">Id</span>   <span class="type">int64</span>
}

<span class="keyword">class</span> <span class="class">Printable</span> {
    <span class="func-keyword">func</span> <span class="function">Print</span>() {
        fmt.Printf(<span class="string">"%v\n"</span>, <span class="this">this</span>)
    }
}

<span class="comment">// Employee class extending Person and Printable, implementing IPrintable</span>
<span class="keyword">class</span> <span class="class">Employee</span> <span class="keyword">use</span> <span class="class">Person</span>, <span class="class">Printable</span> <span class="keyword">must</span> <span class="class">IPrintable</span> {
    <span class="variable">Salary</span> <span class="type">float64</span>

    <span class="comment">// Constructor</span>
    <span class="func-keyword">func</span> <span class="function">Constructor</span>(<span class="variable">name</span> <span class="type">string</span>, <span class="variable">age</span> <span class="type">int</span>, <span class="variable">id</span> <span class="type">int64</span>, <span class="variable">salary</span> <span class="type">float64</span>) {
        <span class="this">this</span>.<span class="variable">Name</span> = <span class="variable">name</span>
        <span class="this">this</span>.<span class="variable">Age</span> = <span class="variable">age</span>
        <span class="this">this</span>.<span class="variable">Id</span> = <span class="variable">id</span>
        <span class="this">this</span>.<span class="variable">Salary</span> = <span class="variable">salary</span>
    }

    <span class="func-keyword">func</span> <span class="function">GetSalary</span>() <span class="type">float64</span> {
        <span class="keyword">return</span> <span class="this">this</span>.<span class="variable">Salary</span>
    }

    <span class="func-keyword">func</span> <span class="function">SetSalary</span>(<span class="variable">salary</span> <span class="type">float64</span>) *<span class="class">Employee</span> {
        <span class="this">this</span>.<span class="variable">Salary</span> = <span class="variable">salary</span>
        <span class="keyword">return</span> <span class="this">this</span>
    }

    <span class="func-keyword">func</span> <span class="function">SumSalary</span>(<span class="variable">rise</span> <span class="type">float64</span>) (*<span class="class">Employee</span>, <span class="type">float64</span>) {
        <span class="this">this</span>.<span class="variable">Salary</span> += <span class="variable">rise</span>
        <span class="keyword">return</span> <span class="this">this</span>, <span class="this">this</span>.<span class="variable">Salary</span>
    }

    <span class="comment">// Implementing Print method</span>
    <span class="func-keyword">func</span> <span class="function">Print</span>() {
        fmt.Printf(<span class="string">"Name: %s\n"</span>, <span class="this">this</span>.<span class="variable">Name</span>)
        fmt.Printf(<span class="string">"Age: %d\n"</span>, <span class="this">this</span>.<span class="variable">Age</span>)
        fmt.Printf(<span class="string">"ID: %d\n"</span>, <span class="this">this</span>.<span class="variable">Id</span>)
        fmt.Printf(<span class="string">"Salary: %.2f\n"</span>, <span class="this">this</span>.<span class="variable">Salary</span>)
    }

    <span class="keyword">static</span> <span class="func-keyword">func</span> <span class="function">TestEmployee</span>(e <span class="type">Employee</span>) {
        fmt.Printf(<span class="string">"Name: %s\n"</span>, e.<span class="variable">Name</span>)
        fmt.Printf(<span class="string">"Age: %d\n"</span>, e.<span class="variable">Age</span>)
        fmt.Printf(<span class="string">"ID: %d\n"</span>, e.<span class="variable">Id</span>)
        fmt.Printf(<span class="string">"Salary: %.2f\n"</span>, e.<span class="variable">Salary</span>)
    }
}

<span class="comment">// Another class implementing IPrintable</span>
<span class="keyword">class</span> <span class="class">Client</span> <span class="keyword">must</span> <span class="class">IPrintable</span> {
    <span class="func-keyword">func</span> <span class="function">Print</span>() {
        fmt.Printf(<span class="string">"Client"</span>)
    }
}

<span class="comment">// Main function to test syntax</span>
<span class="func-keyword">func</span> <span class="function">main</span>() {
    <span class="variable">employee</span> := <span class="keyword">create</span> <span class="class">Employee</span>(<span class="string">"Carlos"</span>, <span class="number">36</span>, <span class="number">1234</span>, <span class="number">10000.00</span>)
    <span class="variable">employee</span>.<span class="function">Print</span>()
    <span class="class">Employee</span>{}.<span class="function">TestEmployee</span>(<span class="variable">employee</span>)
}
</pre>

## Why Choose GoSugar?
- Keep Go’s performance while improving its syntax
- Write cleaner, more expressive code
- Maintain Go compatibility – everything compiles to standard Go
- Reduce boilerplate, making development faster

Learn more: (repository link here)