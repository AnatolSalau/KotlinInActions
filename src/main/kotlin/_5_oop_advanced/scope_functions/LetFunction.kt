package _5_oop_advanced.scope_functions

fun main() {
    // let function - return Unit (void function in Java)
    val sam = PersonLet("Sam", "sam@gmail.com")
    val res = sam.email?.let{ println("Email: $it") }    // Email: sam@gmail.com
    // аналог без функции let
    //if(sam.email!=null) println("Email:${sam.email}")

    val tom = PersonLet("Tom", null)
    tom.email?.let{ println("Email: $it") } // функция let не будет выполняться

}
data class PersonLet(val name: String, val email: String?)