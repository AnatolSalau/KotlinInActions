package _2_functions

fun main() {
    val fn = outer() // fn = inner, так как функция outer возвращает функцию inner
    // вызываем внутреннюю функцию inner
    fn() // 6
    fn() // 7
    fn() // 8
    //---------------------------------
    val func = multiply(5)
    val result1 = func(6) // 30
    println(result1)       // 30

    val result2 = func(5) // 25
    println(result2)          // 25
    //---------------------------------

    val result11 = multiply(5)(6) // 30
    println(result11)       // 30

    val result22 = multiply(5)(5) // 25
    println(result22)          // 25
}
fun outer(): ()->Unit{       // внешняя функция
    var n = 5         // некоторая переменная - лексическое окружение функции inner
    fun inner(){     // вложенная функция
        // действия с переменной n
        n++
        println(n)
    }
    return ::inner
}

fun outerShort(): ()-> Unit{
    var n = 5
    return {
        n++
        println(n)
    }
}

fun multiply(n:Int): (Int)->Int{

    return {m:Int-> n * m}
}