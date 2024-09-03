package _5_oop_advanced



fun main() {

    val tom = PersonSmartCast("Tom")
    val bob = Employee("Bob", "JetBrains")

    checkEmployment(tom)    // Tom does not have a job
    checkEmployment(bob)    // Bob works in JetBrains
}

fun checkEmployment(person: PersonSmartCast){
    // println("${person.name} works in ${person.company}")    // Ошибка - у Person нет свойства company
    if(person !is Employee){
        println("${person.name} does not have a job")
    }
    else{
        println("${person.name} works in ${person.company}")
    }
}
fun identifyPerson(person: PersonSmartCast){
    when(person){
        is Manager -> println("${person.name} is a manager")
        is Employee -> println("${person.name} is an employee")
        is Person -> println("${person.name} is just a person")
    }
}

fun checkCompany(person: PersonSmartCast){
    val employee = person as? Employee
    if (employee!=null){
        println("${employee.name} works in ${employee.company}")
    }
    else{
        println("${person.name} is not an employee")
    }
}

open class PersonSmartCast(val name: String)
open class Employee(name: String, val company: String): PersonSmartCast(name)
class Manager(name: String, company: String): Employee(name, company)