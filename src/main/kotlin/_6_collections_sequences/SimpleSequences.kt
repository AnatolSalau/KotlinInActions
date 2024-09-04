package _6_collections_sequences

fun main() {
    val people = sequenceOf("Tom", "Sam", "Bob")    //тип Sequence<String>
    println(people.joinToString())  // Tom, Sam, Bob

    val employees = listOf("Tom", "Sam", "Bob") // объект List<String>
    val employeeSequence = employees.asSequence()         //тип Sequence<String>
    println(employeeSequence.joinToString())

    var number = 0
    val numbers = generateSequence{ number += 2; number}
    println(numbers.take(5).joinToString())    // получаем первые 5 элементов последовательности - 2, 4, 6, 8, 10

}