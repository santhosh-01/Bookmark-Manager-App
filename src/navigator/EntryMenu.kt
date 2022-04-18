package navigator

import core.LoginValidation
import core.StringConstant
import core.User
import core.UserManagement
import util.OutputDesigner
import validation.IntegerValidator

class EntryMenu(private val userManagement: UserManagement) {

    private val outputDesigner: OutputDesigner = OutputDesigner(172)

    private fun showMenu() {
        println(outputDesigner.getCharLine('#'))
        println("\nEntry Menu")
        println("1. Register")
        println("2. Log In")
        println("3. Change Password")
        println("4. Quit Application")
        println(outputDesigner.getCharLine('#'))
    }

    fun navigate() {
        outer@ while (true) {
            showMenu()
            val choice: Int = IntegerValidator.validateInteger(1, 4)
            if (choice == -1) continue
            if (choice == 1) {
                var mobileNumber: String
                var password: String
                var name: String
                while (true) {
                    print("\nEnter mobile number ['b' for back] : ")
                    mobileNumber = readLine().toString()
                    if (mobileNumber == "b") continue@outer
                    if (!LoginValidation.validateMobileNumber(mobileNumber)) {
                        println(StringConstant.invalidMobileNumberMessage)
                        continue
                    }
                    break
                }
                while (true) {
                    print("\nEnter password : ")
                    password = readLine().toString()
                    if (!LoginValidation.validatePassword(password)) {
                        println(StringConstant.invalidPasswordWithPasswordPolicy)
                        continue
                    }
                    break
                }
                while (true) {
                    print("\nEnter name ['s' to skip] : ")
                    name = readLine().toString()
                    if (name == "") {
                        println(StringConstant.emptyInputMessage)
                        continue
                    }
                    break
                }
                val user: User = if (name == "s") User(mobileNumber, password)
                else User(mobileNumber, password, name)
                userManagement.registerNewUser(user)
                println(StringConstant.registrationSuccessMessage)
            } else if (choice == 2) {
                var mobileNumber: String
                var password: String
                while (true) {
                    print("\nEnter mobile number ['b' for back] : ")
                    mobileNumber = readLine().toString()
                    if (mobileNumber == "b") continue@outer
                    if (!LoginValidation.validateMobileNumber(mobileNumber)) {
                        println(StringConstant.invalidMobileNumberMessage)
                        continue
                    }
                    if (!userManagement.isAnExistingUser(mobileNumber)) {
                        println(StringConstant.mobileNumberNotRegistered)
                        continue
                    }
                    break
                }
                while (true) {
                    print("\nEnter password : ")
                    password = readLine().toString()
                    val isLogin: Boolean = userManagement.loginUser(mobileNumber, password)
                    if (isLogin) {
                        println(StringConstant.loginSuccessMessage)
                        break@outer
                    } else {
                        println(StringConstant.invalidPasswordMessage)
                    }
                }
            } else if (choice == 3) {
                var mobileNumber: String
                var password: String
                var newPassword: String
                while (true) {
                    print("\nEnter mobile number ['b' for back] : ")
                    mobileNumber = readLine().toString()
                    if (mobileNumber == "b") continue@outer
                    if (!LoginValidation.validateMobileNumber(mobileNumber)) {
                        println(StringConstant.invalidMobileNumberMessage)
                        continue
                    }
                    if (!userManagement.isAnExistingUser(mobileNumber)) {
                        println(StringConstant.mobileNumberNotRegistered)
                        continue
                    }
                    break
                }
                while (true) {
                    print("\nEnter password ['b' for back] : ")
                    password = readLine().toString()
                    if (password == "b") continue@outer
                    val isLogin: Boolean = userManagement.loginUser(mobileNumber, password)
                    if (isLogin) {
                        break
                    } else {
                        println(StringConstant.invalidPasswordMessage)
                    }
                }
                while (true) {
                    print("\nEnter new password : ")
                    newPassword = readLine().toString()
                    if (userManagement.changePassword(mobileNumber, password, newPassword)) {
                        println(StringConstant.passwordChangedSuccessMessage)
                        continue@outer
                    } else {
                        println(StringConstant.invalidPasswordMessage)
                    }
                }
            } else if (choice == 4) {
                println(StringConstant.quitMessage)
                break@outer
            }
        }
    }

}