package _8_channels.pipelines.conflatted_channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


suspend fun main(): Unit = coroutineScope {
    // create a buffered channel with capacity of 2
    val channel = Channel<Int>(Channel.CONFLATED)

    // get the starting time to display the time difference in the logs
    val startTime = System.currentTimeMillis()

    this.launch {
        for (message in 1..5) {
            // send the message through the channel and log the message
            channel.send(message)
            log("Producer Sent -> $message", startTime)
        }
        log("All Sent!", startTime)
        // close the channel when all messages are sent
        channel.close()
    }

    // launch a coroutine to consume messages from the channel
    this.launch {
        // consume messages from the channel until it is closed
        channel.consumeEach { message ->
            log("Consumer Received $message", startTime)
            // if channel is not closed then add a delay of 2 seconds to simulate some processing time
            if (!channel.isClosedForReceive) {
                delay(2000)
            }
        }
        log("Receiving Done!", startTime)
    }
}

// To log the message and time
fun log(message: String, startTime: Long) {
    val currentTime = System.currentTimeMillis()
    val diffTime = String.format("%.3f", (currentTime - startTime).toDouble() / 1000)
    println("Channel, [$diffTime] $message")
}

