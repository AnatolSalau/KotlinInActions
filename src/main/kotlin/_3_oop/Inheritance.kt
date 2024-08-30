package _3_oop

import lombok.Data
import lombok.ToString


fun main() {
    val employee: Employee = Employee("EmpName", "CompName")
    println(employee)
}
open class Person(val name: String) {
    fun printName() = println(name)
    override fun toString(): String {
        return "Person(name='$name')"
    }
}
@Data
class Employee(val empName: String, val company: String): Person(empName) {
    fun printCompany() = println(company)
    override fun toString(): String {
        return "Employee(empName='$empName', company='$company')"
    }
}

