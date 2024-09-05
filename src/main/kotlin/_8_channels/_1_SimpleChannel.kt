package _8_channels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

suspend fun main() = coroutineScope{

    val channel = Channel<String>()
    launch {
        val users = listOf("Tom", "Bob", "Sam")
        for (user in users) {
            channel.send(user)  // Отправляем данные в канал
        }
        channel.close()  // Закрытие канала
    }

    for(user in channel) {  // Получаем данные из канала
        println(user)
    }
    println("End")
}