package _5_oop_advanced.scope_functions

fun main() {
    // with change object properties
    val tom = PersonWith("Tom", -19,null)
    with(tom) {
        if(this.email==null) this.email = "${name.lowercase()}@gmail.com"
        if(this.age !in 1..110) this.age = 18
    }
    println("${tom.name} (${tom.age}) - ${tom.email}") // Tom (18) - tom@gmail.com
}
data class PersonWith(val name: String, var age:Int, var email: String?)