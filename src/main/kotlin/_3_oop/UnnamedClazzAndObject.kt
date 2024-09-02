package _3_oop

fun main() {

    val tom = object : PersonObj("Tom"){

        val company = "JetBrains"
        override fun sayHello(){
            println("Hi, my name is $name. I work in $company")
        }
    }

    tom.sayHello()  // Hi, my name is Tom. I work in JetBrains

    val tomFromFunction = createPerson("Tom", "JetBrains")
    println(tomFromFunction.name)   // норм - свойство name унаследовано от Person
    //println(tomFromFunction.company)    // ! Ошибка - свойство недоступно
    tomFromFunction.sayHello()
}
open class PersonObj(val name: String){
    open fun sayHello(){
        println("Hi, my name is $name")
    }
}

private inline fun createPerson(name: String, comp: String) = object: PersonObj(name){
    val company = comp
}
