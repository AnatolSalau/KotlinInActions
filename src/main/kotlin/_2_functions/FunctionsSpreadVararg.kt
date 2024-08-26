package _2_functions

fun main() {

    fun funWithUnnecessaryArgs(firstArg: String = "Default1", secondArg: String = "Default2") {
        println("$firstArg $secondArg")
    }

    funWithUnnecessaryArgs()

    fun funWithVarArg(firstArg: String = "Default3", vararg secondArg: Int, thirdArg: String = "Default4") {
        println("$firstArg $thirdArg")
        println(secondArg.joinToString(" "))
        println("Size : " + secondArg.size)
    }

    funWithVarArg()

    fun changeNumbers(vararg numbers: Int, koef: Int) {
        for (number in numbers)
            println(number * koef)
    }


    val nums = intArrayOf(1, 2, 3, 4)
    changeNumbers(*nums, koef = 2)

}