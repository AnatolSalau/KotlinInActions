
interface Runner {
    fun run()
}
class RunnerImpl(private val speed: Int = 10): Runner {

    override fun run() {
        println("Run function with speed $speed")
    }
}
