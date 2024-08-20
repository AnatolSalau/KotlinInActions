object One {
    var cats: MutableList<String> = arrayListOf<String>()

    fun callCat() {
        cats.forEach { println(it) }
    }
}

fun main() {
    val oneInstance1: One = One

    val oneInstance2: One = One

    oneInstance1.cats.add("FirstCat")
    oneInstance1.cats.add("SecondCat")
    oneInstance1.callCat()

    oneInstance2.cats.removeAt(0)
    println("After removing")
    oneInstance1.callCat()

}