package _3_oop

open class PersonCompanion(val name: String){

    init{
        counter++
    }
    companion object {
        private var counter = 0
        fun printCounter() = println(counter)
    }
}
class EmployeeCompanion(name:String):PersonCompanion(name)

fun main (){

    //Companion object and inheritance
    PersonCompanion.printCounter() // 0
    EmployeeCompanion("Tom")
    PersonCompanion.printCounter() // 1
    // Employee.printCounter() ! Так нельзя - error: unresolved reference: printCounter
}