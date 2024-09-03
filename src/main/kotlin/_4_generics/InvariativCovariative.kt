package _4_generics




//Инвариантность
/*
interface Messenger<T: Message>

open class Message(val text: String)
class EmailMessage(text: String): Message(text)

fun changeMessengerToEmail(obj: Messenger<EmailMessage>){
    val messenger: Messenger<Message> = obj   // ! Ошибка
}
fun changeMessengerToDefault(obj: Messenger<Message>){
    val messenger: Messenger<EmailMessage> = obj      // ! Ошибка
}

fun changeMessengerToDefault(obj: Messenger<Message>){
    val messenger: Messenger<Message> = obj
}
fun changeMessengerToEmail(obj: Messenger<EmailMessage>){
    val messenger: Messenger<EmailMessage> = obj
}
*/


//Ковариантность Consumer -> Super (out)
/*
interface Messenger<out T: Message>
open class Message(val text: String)
class EmailMessage(text: String): Message(text)

fun changeMessengerToEmail(obj: Messenger<EmailMessage>){
    val messenger: Messenger<Message> = obj
}
*/
/*
fun main() {

    val messenger: Messenger<Message> = EmailMessenger()
    val message = messenger.writeMessage("Hello Kotlin")
    println(message.text)    // Email: Hello Kotlin
}
open class Message(val text: String)

class EmailMessage(text: String, val emailMessage: String): Message(text)

interface Messenger<out T: Message>{
    fun writeMessage(text: String): T // out - значит, что возвращаемое значение может быть generic
}
class EmailMessenger(): Messenger<EmailMessage>{
    override fun writeMessage(text: String): EmailMessage {
        return EmailMessage("Email: $text", "emailAddress")
    }
}
*/

//Контрвариантность
/*
    fun main() {

        val messenger: Messenger<EmailMessage> = InstantMessenger() // InstantMessenger - это Messenger<Message>

        val message = EmailMessage("Hi Kotlin")
        messenger.sendMessage(message)
    }
    open class Message(val text: String)

    class EmailMessage(text: String): Message(text)

    interface Messenger<in T: Message>{
        //fun writeMessage(text: String): T
        fun sendMessage(message: T)
    }

    class InstantMessenger(): Messenger<Message>{
        override fun sendMessage(message: Message){
            println("Send message: ${message.text}")
        }
    }
*/