package _7_corutines

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext


suspend fun main() = coroutineScope {
    runUnconfined()
    runIO()
    runSingleThreadContext()
}

suspend fun runUnconfined() = coroutineScope{

    launch(Dispatchers.Unconfined) {
        println("Поток корутины Unconfined(до остановки): ${Thread.currentThread().name}")
        delay(500L)
        println("Поток корутины Unconfined (после остановки): ${Thread.currentThread().name}")
    }

    println("Поток функции runUnconfined: ${Thread.currentThread().name}")
}

suspend fun runIO() = coroutineScope{

    launch(Dispatchers.IO) {
        println("Поток корутины IO (до остановки): ${Thread.currentThread().name}")
        delay(500L)
        println("Поток корутины IO (после остановки): ${Thread.currentThread().name}")
    }

    println("Поток функции runIO: ${Thread.currentThread().name}")
}

@OptIn(DelicateCoroutinesApi::class, ExperimentalCoroutinesApi::class)
suspend fun runSingleThreadContext() = coroutineScope{

    launch(newSingleThreadContext("Custom Thread")) {
        println("Поток корутины SingleThreadContext (до остановки): ${Thread.currentThread().name}")
        delay(500L)
        println("Поток корутины SingleThreadContext : ${Thread.currentThread().name}")
    }

    println("Поток функции runSingleThreadContext: ${Thread.currentThread().name}")
}

