fun main() {
    println(getDayByNum(2))
    println(getDayByNumIfElse(2))
}

fun getDayByNum(number: Int): String {
    return when (number) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        else -> "Unknown"
    }
}

fun getDayByNumIfElse(number: Int): String {
    return  if (number == 1) "Monday"
            else if (number == 2) "Tuesday"
            else if (number == 3) "Wednesday"
            else if (number == 4) "Thursday"
            else "Unknown"
}