package _8_channels.pipelines.rendezvous_channel

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(): Unit = coroutineScope {
    // create a rendezvous channel with capacity 0
    val channel = Channel<Int>()

    // get the starting time to display the time difference in the logs
    val startTime = System.currentTimeMillis()

    // launch the producer coroutine
    this.launch {
        for (i in 1..5) {
            println( "Producer -> Sending $i, $startTime")
            channel.send(i) // send data to the channel
            println( "Producer -> Sent $i, $startTime")
            delay(1)
        }
        channel.close() // close the channel after sending all data
    }

    // launch the consumer coroutine
    this.launch {
        // iterate over the channel until it's closed
        for (value in channel) {
            println("Consumer Received $value, startTime")
        }
    }
}