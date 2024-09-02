package _3_oop

open class Person(val name: String){

    init{
        counter++
    }
    companion object {
        private var counter = 0
        fun printCounter() = println(counter)
    }
}
class Employee(name:String):Person(name)

fun main (){

    //Companion object and inheritance
    Person.printCounter() // 0
    Employee("Tom")
    Person.printCounter() // 1
    // Employee.printCounter() ! Так нельзя - error: unresolved reference: printCounter
}