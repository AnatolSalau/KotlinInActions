package _3_oop

fun main() {
    val person = PersonWithInfo("John", "Full info")
    println(person)
}

open class PersonWithInfo(val name: String) {
    open var fullInfo: String = ""
        get() {
            return field.uppercase()
        }
        set(value) {
            field = value.uppercase()
        }

    constructor(name: String, fullInfo: String) : this(name) {
        this.fullInfo = fullInfo
    }

}

class PersonWithInfoChild(name: String) : PersonWithInfo(name) {
    override var fullInfo: String = ""
        get() = field.lowercase()
        set(value) {
            field = value.lowercase()
        }
}