package _5_oop_advanced

fun main() {
    var name : String?  = "Tom"
    val userName: String = name ?: "Undefined"  // если name = null, то присваивается "Undefined"

    var age: Int? = 23
    val userAge: Int = age ?:0  // если age равно null, то присваивается число 0


    var tom: PersonWithNull? = PersonWithNull("Tom")
    val tomName: String? = tom?.name?.uppercase()
    println(tomName)        // TOM

    var bob: PersonWithNull? = null
    val bobName: String? = bob?.name?.uppercase()
    println(bobName)        // null

    var sam: PersonWithNull? = PersonWithNull(null)
    val samName: String? = sam?.name?.uppercase()
    println(samName)        // null
}
private class PersonWithNull(val name: String?)