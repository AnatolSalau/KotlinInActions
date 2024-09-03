package _4_generics

fun main() {
    val a: Int = 5
    val b: Int = 6
    val biggest = getBiggest(a, b)
    println(biggest)

    val email1 = EmailMessage("Hello Kotlin")
    send(email1)
    val sms1 = SmsMessage("Привет, ты спишь?")
    send(sms1)
}

fun <T> getBiggest(a: T, b: T): T where T: Comparable<T>,
                                        T: Number {
    return if(a > b) a
    else b
}

fun<T> send(message: T) where T: Message, T: Logger{
    message.log()
}

interface Message{ val text: String }
interface Logger{ fun log() }

private class EmailMessage(override val text: String): Message, Logger{
    override fun log() = println("Email: $text")
}
class SmsMessage(override val text: String): Message, Logger{
    override fun log() = println("SMS: $text")
}