import org.w3c.dom.ranges.Range

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    val rangeInt: IntRange = 1..5    // диапазон [1, 2, 3, 4, 5]

    val closedStringRange: ClosedRange<String> =  "a".."d"

    val openEndStringRange : OpenEndRange<String> = "a"..<"d"

    val downRange1: IntProgression = 10 downTo 1 step 3 // 10 7 4 1

    val range1: IntRange = 1 until 9          // 1 2 3 4 5 6 7 8
    val range2: IntProgression = 1 until 9 step 2   // 1 3 5 7

}