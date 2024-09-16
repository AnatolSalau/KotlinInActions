package _9_flows

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.zip

suspend fun main(){

    val names = listOf("Tom", "Bob", "Sam").asFlow()
    val ages = listOf(37, 41, 25).asFlow()
    names.zip(ages) { name, age -> Person(name, age) }
        .collect { person -> println("Name: ${person.name}   Age: ${person.age}") }
}

private data class Person(val name: String, val age: Int)