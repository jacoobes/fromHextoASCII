import kotlin.math.pow

fun main(args: Array<String>) {
    if(args.isEmpty()) throw RuntimeException("No arguments provided")

    when(args[0])  {
      "--encode", "-enc" -> println( textToHex(args[1])  )
      "--decode", "-dec" -> println( hextoText(args[1].split(" ")))
        else -> throw RuntimeException("Not a valid flag")
    }


}
fun recurseDigit(decimalCode: Int) : String {
    val quotient = decimalCode / 16
    val remainder = decimalCode % 16
    val mapLetter = mapOf(10 to "a", 11 to "b", 12 to "c", 13 to "d", 14 to "e", 15 to "f")

    return if (quotient == 0)  remainder.toString()
    else recurseDigit(quotient) + mapLetter.getOrElse(remainder) { remainder }
}

fun textToHex(codes: String): String = codes.map { recurseDigit(it.code) }.joinToString(" ")


fun multiply16(hexCode : String): Char {


    val (first, second) = hexCode

    return (first + second).toChar()
}
private operator fun String.component1(): Int = this[0].toString().toInt() * 16

private operator fun String.component2(): Int {
    val mapLetter = mapOf('a' to 10, 'b' to 11 , 'c' to 12, 'd' to 13, 'e' to 14, 'f' to 15)
   return if( this[1].isLetter() ) mapLetter[this[1]]!! * zero() else this[1].toString().toInt() * zero()
}
private fun zero() = 1.0.pow(0.0).toInt()



fun hextoText(codes: List<String>) = codes.map { multiply16(it)  }.joinToString("")