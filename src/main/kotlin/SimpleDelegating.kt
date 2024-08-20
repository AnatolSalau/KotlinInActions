interface Runner {
    fun run()
}

class RunnerImpl(private val speed: Int = 10) : Runner {
    override fun run() {
        println("Run function from RunnerImpl with speed $speed")
    }
}

class ParentWhoCanRun(private val runner: Runner) : Runner by runner

class ParentWhoCanRunOver(private val speed: Int = 100, private val runner: Runner) : Runner by runner {

    override fun run() {
        println("Run function from RunnerImpl with speed $speed")
    }
}

fun main() {
    val runner: Runner = RunnerImpl(20)
    val parent: Runner = ParentWhoCanRun(runner);

    parent.run()

    val parentWhoCanOver: Runner = ParentWhoCanRunOver(200, runner);
    parentWhoCanOver.run()
}


