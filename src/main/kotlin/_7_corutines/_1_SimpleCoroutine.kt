package _7_corutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    fun main() = runBlocking { // this: CoroutineScope
        launch { // launch a new coroutine and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            println("World!") // print after delay
        }
        println("Hello") // main coroutine continues while a previous one is delayed
    }
*/
suspend fun main(): kotlin.Unit = coroutineScope{
    launch{ doWork() }

    println("Hello Coroutines")
}

suspend fun doWork(){
    for(i in 0..5){
        println(i)
        delay(400L)
    }
}