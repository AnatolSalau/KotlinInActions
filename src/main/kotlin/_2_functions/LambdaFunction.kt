package _2_functions

fun main() {
    val hello: ()->Unit = {println("Hello Kotlin")}
    hello()
    hello()

    val printer: (String) -> Unit = {message: String ->
        val uppercase = message.uppercase()
        println(uppercase)
    }
    printer("Hello")
    printer("Good Bye");

    // or

    {message: String -> println(message)}("Welcome to Kotlin")

    val sum = {x:Int, y:Int -> x + y }
    doOperationWithLambda(3, 4, sum)

    //Trailing lambda
    doOperation(3, 4, {a, b -> a * b})
    doOperation(3, 4) {a, b -> a * b}

    //Return action

    val action2 = selectActionWithLambda(3)
    val result2 = action2(4, 5)
    println(result2)        // 20

    val action3 = selectActionWithLambda(9)
    val result3 = action3(4, 5)
    println(result3)        // 0
}

fun doOperationWithLambda(x: Int, y: Int, op: (Int, Int) ->Int){

    val result = op(x, y)
    println(result)
}

fun selectActionWithLambda(key: Int): (Int, Int) -> Int{
    // определение возвращаемого результата
    when(key){
        1 -> return {x, y -> x + y }
        2 -> return {x, y -> x - y }
        3 -> return {x, y -> x * y }
        else -> return {_, _ -> 0 } // неиспользуемые параметры
    }
}