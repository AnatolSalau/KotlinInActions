package _3_oop

interface Printable{
    fun printName()
}

enum class DayTime: Printable{
    DAY{
        override val startHour = 6
        override val endHour = 21
        override fun printName(){
            println("День")
        }
    },
    NIGHT{
        override val startHour = 22
        override val endHour = 5
        override fun printName(){
            println("Ночь")
        }
    };
    abstract override fun printName()
    abstract val startHour: Int
    abstract val endHour: Int
}

enum class Operation{

    ADD, SUBTRACT, MULTIPLY
}
fun operate(n1: Int, n2: Int, op: Operation): Int{

    return when(op){
        Operation.ADD -> n1 + n2
        Operation.SUBTRACT -> n1 - n2
        Operation.MULTIPLY -> n1 *n2
    }
}

fun main() {

    DayTime.DAY.printName()     // День
    DayTime.NIGHT.printName()   // Ночь

    println("Day from DayTimeInner ${DayTime.DAY.startHour} to ${DayTime.DAY.endHour}")

    println(operate(5, 6, Operation.ADD))         // 11
    println(operate(5, 6, Operation.SUBTRACT))   // -1
    println(operate(5, 6, Operation.MULTIPLY))   // 30
}