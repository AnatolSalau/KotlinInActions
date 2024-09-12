package _8_channels.pipelines.unlimited_channels

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

data class Event(val timestamp: Long, val message: String)

suspend fun eventProducer(eventChannel: Channel<Event>) {
    while (true) {
        delay(Random.nextLong(500, 2000)) // Simulate irregular intervals between events
        val eventMessage = when (Random.nextInt(1, 4)) {
            1 -> "User clicked on button XYZ"
            2 -> "System error occurred"
            3 -> "Network activity detected"
            else -> "Unknown event"
        }
        val event = Event(System.currentTimeMillis(), eventMessage)
        eventChannel.send(event)
        println("Event sent: $event")
    }
}

suspend fun loggingCoroutine(eventChannel: Channel<Event>) {
    eventChannel.consumeEach { event ->
        // Process the event (e.g., store it in a database, write to a file, or send to an external service)
        println("Processing event: $event")
    }
}

suspend fun main(): Unit = coroutineScope {
    val eventChannel = Channel<Event>(Channel.UNLIMITED)

    // Launch multiple event producers
    repeat(5) {
        launch { eventProducer(eventChannel) }
    }

    // Launch the logging coroutine
    launch { loggingCoroutine(eventChannel) }

    // Keep the application running
    delay(2000)
    eventChannel.close()
}