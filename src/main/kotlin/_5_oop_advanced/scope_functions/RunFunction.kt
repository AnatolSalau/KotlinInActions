package _5_oop_advanced.scope_functions

fun main() {
// run function like with but extension function
    val tom = Person("Tom", null)
    val emailOfTom = tom.run {
        if(this.email==null)
            this.email = "${name.lowercase()}@gmail.com"
        this.email
    }
    println(emailOfTom) // tom@gmail.com

    //or just lambda
    val randomText = run{ "hello world"}
    println(randomText)  // hello world

    run{ println("run function")}    // run function
}
data class Person(val name: String, var email: String?)