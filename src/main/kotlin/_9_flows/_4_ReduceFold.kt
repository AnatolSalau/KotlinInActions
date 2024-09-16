package _9_flows

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.reduce

suspend fun main(){

    val numberFlow = listOf(1, 2, 3, 4, 5).asFlow()
    val reducedValue = numberFlow.reduce{ a, b -> a + b }
    println(reducedValue)   // 15

    val userFlow = listOf("Tom", "Bob", "Kate", "Sam", "Alice").asFlow()
    val foldedValue = userFlow.fold("Users:", { a, b -> "$a $b" })
    println(foldedValue)   // Users: Tom Bob Kate Sam Alice

}