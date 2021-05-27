package subtask3

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val firstRegex = Regex("""[<({\[]""")
        val array = arrayListOf<String>()
        for (i in inputString.indices) {
            val firstChar = inputString[i].toString()
            if (firstChar.contains(firstRegex)) {
                var count = 0
                val secondChar = revers(inputString[i])
                for (x in i until inputString.length) {
                    if (inputString[x].toString().contains(firstChar)) {
                        count = count.inc()
                    }
                    if (inputString[x].toString().contains(secondChar)) {
                        count = count.dec()
                        if (count == 0) {
                            array.add(inputString.subSequence(i + 1, x).toString().trim())
                            break
                        }
                    }
                }
            }
        }
        return array.toTypedArray()
    }

    private fun revers(char: Char): String {
        return when (char.toString()) {
            "<" -> ">"
            "(" -> ")"
            "{" -> "}"
            else -> "]"
        }
    }
}