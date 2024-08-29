package _2_functions

fun main() {
    action(5, 3, ::sum)         // 8
    action(5, 3, ::subtract)
    action(2,2, ::multiply)

    val action1 = selectAction(1)
    println(action1(8,5))    // 13

    val action2 = selectAction(2)
    println(action2(8,5))    // 3
}

fun action (n1: Int, n2: Int, op: (Int, Int)-> Int){
    val result = op(n1, n2)
    println(result)
}

fun multiply(a: Int, b: Int): Int{
    return a * b
}

fun selectAction(key: Int): (Int, Int) -> Int{
    return when(key){
        1 -> ::sum
        2 -> ::subtract
        3 -> ::multiply
        else -> ::empty
    }
}
fun empty (a: Int, b: Int): Int{
    return 0
}