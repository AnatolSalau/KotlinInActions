package _8_channels.pipelines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.Channel.Factory.CONFLATED
import kotlinx.coroutines.channels.Channel.Factory.UNLIMITED
import kotlinx.coroutines.coroutineScope

/*
 * <a href="https://medium.com/@mortitech/mastering-kotlin-channels-from-beginner-to-pro-part-2-3477255aee15">...</a>
 */
suspend fun main(): Unit = coroutineScope {
    val rendezvousChannel = Channel<String>(0) //Rendezvous channel - Channel with zero capacity
    val bufferedChannel = Channel<String>(10)
    val conflatedChannel = Channel<String>(CONFLATED)
    val unlimitedChannel = Channel<String>(UNLIMITED)
}