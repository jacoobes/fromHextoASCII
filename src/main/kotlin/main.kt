
fun main(args: Array<String>) {
    if(args.isEmpty()) throw RuntimeException("No arguments provided")

    println(textToHex(args[0]))
}
fun recurseDigit(decimalCode: Int) : String {
    val quotient = decimalCode / 16
    val remainder = decimalCode % 16
    val mapLetter = mapOf(10 to "a", 11 to "b", 12 to "c", 13 to "d", 14 to "e", 15 to "f")

    return if (quotient == 0)  remainder.toString()
    else recurseDigit(quotient) + mapLetter.getOrElse(remainder) { remainder }
}

fun textToHex(codes: String): String {
    return codes.map { recurseDigit(it.code) } .joinToString(" ")
}
