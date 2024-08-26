package _1_basic

class Singleton private constructor() {
    fun printSMT() {
        println("Hello from singleton")
    }

    companion object {

        @Volatile private var instance: Singleton? = null // Volatile modifier is necessary

        fun getInstance() =
            instance ?: synchronized(this) { // synchronized to avoid concurrency problem
                instance ?: Singleton().also { instance = it }
            }
    }
}

fun main() {
    val instance: Singleton = Singleton.getInstance()
    instance.printSMT()
}