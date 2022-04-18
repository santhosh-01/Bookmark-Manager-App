package core

object LoginValidation {

    fun validateMobileNumber(mobileNumber: String): Boolean {
        return mobileNumber.length == 10 && mobileNumber.all { it.isDigit() }
    }

    fun printPasswordPolicy() {
        println("1. Password should be at least 8 characters")
        println("2. Password should have at least 1 small letter")
        println("3. Password should have at least 1 capital letter")
        println("4. Password should have at least 1 special character")
        println("5. Password should have at least 1 digit")
    }

    fun validatePassword(password: String): Boolean {
        return password.length >= 8 && password.any { it.isLowerCase() } && password.any { it.isUpperCase() } &&
                password.any { it.isDigit() } && password.any { it.isSpecialCharacter() }
    }

    private fun Char.isSpecialCharacter(): Boolean {
        return !this.isLetterOrDigit()
    }

}