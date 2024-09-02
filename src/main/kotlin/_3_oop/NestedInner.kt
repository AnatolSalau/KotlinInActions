package _3_oop

class PersonNested {
    class Account(val username: String, val password: String){

        fun showDetails(){
            println("UserName: $username  Password: $password")
        }
    }
}

fun main() {

    val acc = BankAccount(3400);
    acc.Transaction(2400).pay()
}
class BankAccount(private var sum: Int){

    fun display(){
        println("sum = $sum")
    }

    inner class Transaction(private var sum: Int){
        fun pay(){
            this@BankAccount.sum -= this@Transaction.sum
            display()
        }
    }
}

