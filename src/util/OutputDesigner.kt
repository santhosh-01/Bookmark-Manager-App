package util

class OutputDesigner(private val maxChar: Int) {

    fun getModifiedString(str: String,spaceFill: Char): String {
        val result: String = "\n"
        return result + StringFormatter.center(str, maxChar, spaceFill)
    }

    fun getCharLine(spaceFill: Char): String {
        val result: String = "\n"
        return result + StringFormatter.getCharLine(spaceFill,maxChar)
    }

}