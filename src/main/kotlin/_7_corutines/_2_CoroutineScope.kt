package _7_corutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
    suspend fun main()= coroutineScope{

        launch{
            for(i in 0..5){
                delay(400L)
                println(i)
            }
        }
        launch{
            for(i in 6..10){
                delay(400L)
                println(i)
            }
        }

        println("Hello Coroutines")
    }
*/

fun main() = runBlocking{
    launch{
        for(i in 0..5){
            delay(400L)
            println(i)
        }
    }

    println("Hello Coroutines")
}