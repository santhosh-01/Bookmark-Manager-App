package validation

object IntegerValidator {

    fun validateInteger(lowerLimit: Int, upperLimit: Int): Int {
        print("\nEnter your choice : ")
        val choice: Int
        try {
            choice = Integer.parseInt(readLine())
        }
        catch (e: Exception) {
            println("\nYou have entered non integers! Please Enter Valid choice ($lowerLimit to $upperLimit) ")
            return -1
        }
        if(choice < lowerLimit || choice > upperLimit) {
            println("\nGiven choice is Invalid! Please Enter Valid choice ($lowerLimit to $upperLimit) ")
            return -1
        }
        return choice
    }

}