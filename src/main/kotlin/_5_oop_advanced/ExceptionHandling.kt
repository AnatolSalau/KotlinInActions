package _5_oop_advanced

fun main() {
    val checkedAge2 = try { checkAge(-125) } catch (e: Exception) { println(e.message); 18 }
    println(checkedAge2)
}
fun checkAge(age: Int): Int{
    if(age < 1 || age > 110) throw  Exception("Invalid value $age. Age must be greater than 0 and less than 110")
    println("Age $age is valid")
    return age
}