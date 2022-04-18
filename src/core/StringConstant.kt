package core

import util.OutputDesigner

object StringConstant {

    private val outputDesigner: OutputDesigner = OutputDesigner(172)

    val invalidMobileNumberMessage: String = outputDesigner.getModifiedString(" You have entered invalid mobile number ", 'x')
    val invalidPasswordWithPasswordPolicy: String = outputDesigner.getModifiedString(
        " Your password does not match with password policy ", 'x')
    val emptyInputMessage: String = outputDesigner.getModifiedString(" You have given empty input ", 'x')
    val mobileNumberNotRegistered: String = outputDesigner.getModifiedString(
        " Sorry! Given mobile number is not registered! ", 'x')
    val loginSuccessMessage: String = outputDesigner.getModifiedString(" Login Successful! ",'-')
    val invalidPasswordMessage: String = outputDesigner.getModifiedString(" Invalid Password! ", 'x')
    val registrationSuccessMessage: String = outputDesigner.getModifiedString(" Registration is successful! ", '-')
    val appWelcomeMessage: String = outputDesigner.getModifiedString(" Welcome to Bookmark Manager Application ",'*')
    val quitMessage: String = outputDesigner.getModifiedString(" Thank you for using the application ", '-')
    val logoutMessage: String = outputDesigner.getModifiedString(" User logged out successfully ", '-')
    val nonIntegerMessage: String = outputDesigner.getModifiedString(" User logged out successfully ", '-')
    val invalidCategoryId: String = outputDesigner.getModifiedString(" You have entered invalid category id ", '-')
    val invalidBookmarkId: String = outputDesigner.getModifiedString(" You have entered invalid bookmark id ", '-')
    val passwordChangedSuccessMessage: String = outputDesigner.getModifiedString(
        " Password Changed Successfully ", '-')
}