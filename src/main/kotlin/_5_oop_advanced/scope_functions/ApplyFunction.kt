package _5_oop_advanced.scope_functions

fun main() {

    val bob = Employee()
    bob.name("Bob")
    bob.age(26)
    bob.company("JetBrains")
    println("${bob.name} (${bob.age}) - ${bob.company}") // Bob (26) - JetBrains
}

data class Employee(var name: String = "", var age: Int = 0, var company: String = "") {
    fun age(age: Int): Employee = apply { this.age = age }
    fun name(name: String): Employee = apply { this.name = name }
    fun company(company: String): Employee = apply { this.company = company }
}