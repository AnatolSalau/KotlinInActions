package _2_functions

fun main() {
    val refToFun = fun (x: Int, y: Int): Int = x + y

    println(refToFun(1,2))

    doOperation(9, 5, refToFun)

    doOperation(9, 5, fun (x: Int, y: Int): Int = x + y)

    val action1 = returnAction(1)
    val result1 = action1(4, 5)
    println(result1)        // 9

    val action2 = returnAction(3)
    val result2 = action2(4, 5)
    println(result2)        //
}

fun doOperation(x: Int, y: Int, op: (Int, Int) ->Int){

    val result = op(x, y)
    println(result)
}

fun returnAction(key: Int): (Int, Int) -> Int{
    // определение возвращаемого результата
    return when(key){
        1 -> fun(x: Int, y: Int): Int = x + y
        2 -> fun(x: Int, y: Int): Int = x - y
        3 -> fun(x: Int, y: Int): Int = x * y
        else -> fun(x: Int, y: Int): Int = 0
    }
}