import kotlin.reflect.KProperty

fun main() {

    val tom = Person("Tom", 37)
    println(tom.age)    //37
    tom.age = 38
    println(tom.age)    //38
    tom.age = -139
    println(tom.age)    //38

}
class Person(val name: String, _age: Int){
    var age: Int by LoggerDelegate(_age)
}
class LoggerDelegate(private var personAge: Int) {
    operator fun getValue(thisRef: Person, property: KProperty<*>): Int{
        return personAge
    }
    operator fun setValue(thisRef: Person, property: KProperty<*>, value: Int){
        println("Устанавливаемое значение: $value")
        if(value > 0 && value < 110) personAge = value
    }
}