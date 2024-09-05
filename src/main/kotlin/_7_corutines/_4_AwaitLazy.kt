package _7_corutines

import kotlinx.coroutines.*

suspend fun main() = coroutineScope{

    // корутина создана, но не запущена
    val sum = async(start = CoroutineStart.LAZY){ sum(1, 2)}

    delay(1000L)
    println("Actions after the coroutine creation")
    sum.start()                      // запуск корутины
    println("sum: ${sum.await()}")   // получаем результат
}
private fun sum(a: Int, b: Int) : Int{
    println("Coroutine has started")
    return a + b
}