import java.time.LocalDate
@OptIn(ExperimentalStdlibApi::class)
fun main() {
    val startDate = LocalDate.of(2020, 1, 1)

    val endDate = LocalDate.of(2020, 12, 31)


    for (date in startDate..endDate) {

        println("${date.dayOfWeek} $date ")

    }
}

