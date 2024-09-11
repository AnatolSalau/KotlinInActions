package _8_channels.pipelines

import kotlinx.coroutines.launch

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.coroutineScope


suspend fun main(): Unit = coroutineScope {
    val channel = Channel<String>() // Channel exchanges a data of String type

    // Producer starts sending data inside a coroutine
    launch {
        println("Channel, Sent data 1 to channel")
        channel.send("Data 1")
        println("Channel,Sent data 2 to channel")
        channel.send("Data 2")
        channel.close() // we're done sending so channel should be closed
    }
// Consumer starts receiving data inside another coroutine
    launch {
        channel.consumeEach {
            println("Channel, Received: $it")
        }
        println("Channel, Done!") // This line called when channel is closed
    }
}