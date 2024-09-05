package _7_corutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope{

    // корутина создана, но не запущена
    val job = launch(start = CoroutineStart.LAZY) {
        delay(200L)
        println("Coroutine has started")
    }

    delay(1000L)
    job.start() // запускаем корутину
    println("Other actions in main method")
}