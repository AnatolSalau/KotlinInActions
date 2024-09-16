package _9_flows

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf


suspend fun main() {

    val numberFlow: Flow<Int> = getNumbersByFlow()
    numberFlow.collect { n -> println(n) }

    // create flow without function
    val userFlow = flow {
        val usersList = listOf("Tom", "Bob", "Sam")
        for (item in usersList){
            emit(item)
        }
    }
    userFlow.collect({user -> println(user)})

    // create flow by FlowOf
    val numberFlowByFlowOf : Flow<Int> = flowOf(1, 2, 3, 5, 8)
    numberFlowByFlowOf.collect{n -> println(n)}

    // Convert range to flow
    val numberFromRangeFlow : Flow<Int> = (1..5).asFlow()
    numberFromRangeFlow.collect{n -> println(n)}

    // преобразование коллекции List<String> в поток
    val userFlowFromList = listOf("Tom", "Sam", "Bob").asFlow()
    userFlowFromList.collect({user -> println(user)})


}
fun getNumbersByFlow() = flow{
    for(item in 1..5){
        emit(item * item)
    }
}

