package _8_channels.pipelines.unlimited_channels

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val taskChannel = Channel<() -> Unit>(Channel.UNLIMITED)

suspend fun taskProducer(taskChannel: Channel<() -> Unit>) {
    // Generate a task and send it to the channel
    val task = { println("Executing task") }
    taskChannel.send(task)
}

// receives tasks from the producer and executes them
suspend fun taskWorker(taskChannel: Channel<() -> Unit>) {
    taskChannel.consumeEach { task ->
        // Execute the task
        task()
    }
}

fun main(): Unit = runBlocking  { // runBlocking() function is used to start the main coroutine and wait for all other coroutines to complete
    repeat(5) { launch { taskProducer(taskChannel) } }
    launch { taskWorker(taskChannel) }

    delay(2000)
    taskChannel.close()
}