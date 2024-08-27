package _2_functions

fun main() {

    val message: () -> Unit
    message = ::hello
    message()

    // operation указывает на функцию sum
    var operation: (Int, Int) -> Int = ::sum
    val result1 = operation(14, 5)
    println(result1) // 19

    // operation указывает на функцию subtract
    operation = ::subtract
    val result2 = operation(14, 5)
    println(result2) // 9
}

fun hello(){
    println("Hello Kotlin")
}

fun sum(a: Int, b: Int): Int{
    return a + b
}

fun subtract(a: Int, b: Int): Int{
    return a - b
}