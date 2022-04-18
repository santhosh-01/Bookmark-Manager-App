package util

class StringFormatter {

    companion object {
        fun center(str: String, maxChar: Int, spaceFill: Char = ' '): String {
            val spaceFillString = spaceFill.toString()
            val length = str.length
            val totalSpaces = maxChar - length
            val spaces = totalSpaces / 2
            return if (totalSpaces % 2 == 0) {
                spaceFillString.repeat(spaces) + str + spaceFillString.repeat(spaces)
            } else {
                spaceFillString.repeat(spaces + 1) + str + spaceFillString.repeat(spaces)
            }
        }
        fun getCharLine(lineFill: Char, maxChar: Int): String? {
            val lineFillString = lineFill.toString()
            return lineFillString.repeat(maxChar)
        }
    }

}