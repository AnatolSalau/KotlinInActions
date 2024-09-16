package _9_flows


import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform

suspend fun main(){

    val personFlow = listOf(
        PersonForFlow("Tom", 37),
        PersonForFlow("Bill", 5),
        PersonForFlow("Sam", 14),
        PersonForFlow("Bob", 21),
    ).asFlow()

    personFlow.map{ person -> object{
        val name = person.name
        val isAdult = person.age > 17
    }}.collect { user -> println("name: ${user.name}   adult:  ${user.isAdult} ")}

    // transform by function transform
    val peopleFlow = listOf(
        PersonForFlow("Tom", 37),
        PersonForFlow("Bill", 5),
        PersonForFlow("Sam", 14),
        PersonForFlow("Bob", 21),
    ).asFlow()

    peopleFlow.transform{ person ->
        if(person.age > 17){
            emit(person.name)
        }
    }.collect { personName -> println(personName)}
}

data class PersonForFlow(val name: String, val age: Int)
