fun main() {

    val parent1 = object {
        val name: String = "Parent1"
        var surname: String = "Parent1 Surname"
    }

    println(parent1.name)

    parent1.surname = "New Surname"

    println(parent1.surname)
}
