package _7_corutines

import kotlinx.coroutines.*

suspend fun main() = coroutineScope{

    launch {
        println("Корутина выполняется на потоке: ${Thread.currentThread().name}")
    }
    println("Функция main выполняется на потоке: ${Thread.currentThread().name}")
}