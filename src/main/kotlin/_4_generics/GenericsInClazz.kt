package _4_generics

fun main() {
    val email1 = EmailMessageInClass("Hello Kotlin")
    val outlook = Messenger<EmailMessageInClass>()
    outlook.send(email1)

    val skype = Messenger<SmsMessageInClass>()
    val sms1 = SmsMessageInClass("Привет, ты спишь?")
    skype.send(sms1)
}
class Messenger<T>() where T: MessageInClass, T: LoggerInClass{
    fun send(mes: T){
        mes.log()
    }
}
interface MessageInClass{ val text: String }
interface LoggerInClass{ fun log() }

class EmailMessageInClass(override val text: String): MessageInClass, LoggerInClass{
    override fun log() = println("Email: $text")
}
class SmsMessageInClass(override val text: String): MessageInClass, LoggerInClass{
    override fun log() = println("SMS: $text")
}

