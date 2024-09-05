package _7_corutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope{

    val job = launch{
        for(i in 1..5){
            println(i)
            delay(400L)
        }
    }

    println("Start")
    job.join() // ожидаем завершения корутины
    println("End")
}