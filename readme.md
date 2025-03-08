<style>
  /* Monokai Theme for Markdown Code Blocks */
  pre {
    background-color: #272822; /* Fundo escuro */
    color: #F8F8F2; /* Cor padrão do texto */
    padding: 10px;
    border-radius: 5px;
    overflow-x: auto;
  }

  .keyword { color: #F92672; font-weight: bold; } /* Palavras-chave (ex: package, class, use, must) */
  .string { color: #E6DB74; } /* Strings */
  .comment { color: #75715E; font-style: italic; } /* Comentários */
  .type { color: #66D9EF; font-weight: bold; } /* Tipos de retorno e tipos de dados */
  .number { color: #AE81FF; } /* Números */
  .func-keyword { color: #66D9EF; font-weight: bold; } /* 'func' em azul */
  .function { color: #A6E22E; font-weight: bold; } /* Nomes de funções em verde */
  .operator { color: #F92672; } /* Operadores como =, +, : */
  .variable { color: #F8F8F2; } /* Variáveis e propriedades (brancas) */
  .class { color: #A6E22E; font-weight: bold; } /* Nome de classes */
  .this { color: #FD971F; font-weight: bold; } /* 'this' agora está laranja */
</style>

# GoSugar – A Little Sugar for Go

GoSugar is a **dialect of Go** designed to enhance Go’s simplicity with powerful **object-oriented** features while maintaining full compatibility. It **transpiles to standard Go**, ensuring you can leverage GoSugar’s syntax improvements without sacrificing performance.

## Why GoSugar?

Go is a powerful language, but sometimes it lacks certain high-level features found in other languages. GoSugar introduces enhancements to make Go development more expressive and productive while keeping Go’s philosophy intact.

## Features Added to Go

GoSugar enhances Go by introducing:

1. Classes (class keyword)
2. Mandatory Interfaces (must keyword)
3. Methods 
4. Constructors (explicit and automatic)
5. create keyword (like new in other languages)
6. foreach loop (simpler iteration over collections)
7. Static Methods
8. Automatic Constructors (reducing boilerplate)
9. this keyword (inside methods for clarity)
10. Extending Built-in Types (as keyword)
11. Simulated Inheritance via Composition (use keyword)
12. Modern Lambda/Anonymous Function Syntax

## Example code

<pre>
<span class="keyword">package</span> <span class="function">main</span>

<span class="keyword">import</span> (
    <span class="string">"fmt"</span>
)

<span class="comment">// Interfaces</span>
<span class="keyword">interface</span> <span class="class">IPrintable</span> {
    <span class="func-keyword">func</span> <span class="function">Print</span>()
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