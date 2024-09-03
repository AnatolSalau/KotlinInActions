package _5_oop_advanced.scope_functions

fun main() {

    val tom = PersonAlso("Tom", null)
    tom.also {
        if(it.email==null)
            it.email = "${it.name.lowercase()}@gmail.com"
    }
    println(tom.email) // tom@gmail.com
}
data class PersonAlso(val name: String, var email: String?)
