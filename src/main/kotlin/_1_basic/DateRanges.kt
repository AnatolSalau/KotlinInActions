import java.time.LocalDate

// Extension function to create a progression for LocalDate
operator fun LocalDate.rangeTo(other: LocalDate) = DateProgression(this, other, 1)

class DateProgression(
    override val start: LocalDate,
    override val endInclusive: LocalDate,
    val stepDays: Long
) : Iterable<LocalDate>, ClosedRange<LocalDate> {

    override fun iterator(): Iterator<LocalDate> =
        DateIterator(start, endInclusive, stepDays)

}

class DateIterator(
    startDate: LocalDate,
    private val endDate: LocalDate,
    private val stepDays: Long
) : Iterator<LocalDate> {

    private var currentDate = startDate

    override fun hasNext(): Boolean = currentDate <= endDate

    override fun next(): LocalDate {
        val next = currentDate
        currentDate = currentDate.plusDays(stepDays)
        return next
    }
}

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    // Extension function to iterate over LocalDate ranges
    fun ClosedRange<LocalDate>.asSequence(): Sequence<LocalDate> =
        generateSequence(start) { it.plusDays(1).takeIf { it <= endInclusive } }

    val startDate = LocalDate.of(2020, 1, 1)

    val endDate = LocalDate.of(2020, 12, 31)

    val dateRange: ClosedRange<LocalDate> = startDate..endDate

    for (date in dateRange.asSequence()) {
        println("${date.dayOfWeek} $date")
    }
}

