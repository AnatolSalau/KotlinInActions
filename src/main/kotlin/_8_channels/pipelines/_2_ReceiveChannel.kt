package _8_channels.pipelines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    var channel: ReceiveChannel<String> = Channel()
    // Producer Coroutine
    this.launch {
        channel = produce {
            send("A")
            send("B")
            send("C")
            send("D")
            // we don't have to close the channel explicitly
        }
    }

    // Consumer Coroutine
    this.launch {
        channel.consumeEach {
            println("Received $it")
        }
        // sending back data to channel inside consumer coroutine is not possible
        // because it is a ReceiveChannel
        // channel.send("E")

        // channel is automatically closed
        println("Is producer closed: ${channel.isClosedForReceive}")
        }
}