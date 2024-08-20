interface CanSwim {
    fun swim();
}
fun main() {
    //unanimous object
    val parent1 = object {
        val name: String = "Parent1"
        var surname: String = "Parent1 Surname"
    }
    println(parent1.name)
    parent1.surname = "New Surname"
    println(parent1.surname)

    // unanimous object with inheritance
    val swimObj = object : CanSwim {
        override fun swim() {
            println("I can Swim")
        }
    }
    swimObj.swim()
}
