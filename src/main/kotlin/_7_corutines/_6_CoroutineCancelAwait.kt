package _7_corutines

import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlin.coroutines.cancellation.CancellationException

suspend fun main() = coroutineScope{

    // создаем и запускаем корутину
    val message = async {
        getMessage()
    }
    // отмена корутины
    message.cancelAndJoin()

    try {
        // ожидаем получение результата
        println("message: ${message.await()}")
    }
    catch (e:CancellationException){
        println("Coroutine has been canceled")
    }
    println("Program has finished")
}

suspend fun getMessage() : String{
    delay(500L)
    return "Hello"
}