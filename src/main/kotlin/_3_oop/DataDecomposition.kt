package _3_oop

fun main() {

    val alice: PersonData = PersonData("Alice", 24)

    val (username, userage) = alice
    println("Name: $username  Age: $userage") // Name: Alice  Age: 24
}

data class PersonData(var name: String, var age: Int)