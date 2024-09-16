package _9_flows

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope<Unit>{
    launch {
        getUsersByCoroutine().forEach { user ->  println("$user from coroutine") }
    }

    val userFlow: Flow<String> = getUsersByFlow()

    println("Flow is entered but not run yet")

    userFlow.collect { user -> println(user) }
}

suspend fun getUsersByCoroutine(): List<String> {
    delay(1000L)  // имитация продолжительной работы
    return listOf("Tom", "Bob", "Sam")
}

fun getUsersByFlow(): Flow<String> = flow {
    val database = listOf("Tom", "Bob", "Sam")  // условная база данных
    var i = 1;
    for (item in database){
        delay(400L) // имитация продолжительной работы
        println("Emit $i item")
        emit(item) // емитируем значение
        i++
    }
}