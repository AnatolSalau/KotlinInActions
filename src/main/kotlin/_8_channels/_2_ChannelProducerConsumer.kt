package _8_channels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*

suspend fun main() {
    consumeAllUsers()



}

@OptIn(ExperimentalCoroutinesApi::class)
fun CoroutineScope.getUsers(): ReceiveChannel<String> = produce{
    val users = listOf("Tom", "Bob", "Sam", "Forth", "Fifth")
    for (user in users) {
        send(user)
    }
}

suspend fun consumeAllUsers()= coroutineScope {
    println("Start")
    val users = getUsers()
    users.consumeEach { user -> println(user) }
    println("End")
}

