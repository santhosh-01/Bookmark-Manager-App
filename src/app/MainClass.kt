package app

import core.*
import navigator.BookmarkMenu
import navigator.EntryMenu
import navigator.MainMenu
import util.OutputDesigner

fun main(args: Array<String>) {

    val outputDesigner: OutputDesigner = OutputDesigner(172)
    println(StringConstant.appWelcomeMessage)

    val userMaster: UserMaster = UserMaster()
    val userManagement: UserManagement = UserManagement(userMaster)
    userManagement.registerNewUser(User("8526044437","Santhosh@123","Santhosh"))
    userManagement.registerNewUser(User("8360278014","Santhosh@321"))
    val categoryManagement: CategoryManagement = CategoryManagement(CategoryList())
    val bookmarkManagement: BookmarkManagement = BookmarkManagement(BookmarkList())
    val entryMenu: EntryMenu = EntryMenu(userManagement)
    val mainMenu: MainMenu = MainMenu(categoryManagement)
    val bookmarkMenu: BookmarkMenu = BookmarkMenu(bookmarkManagement)
    outer@while (true) {
        entryMenu.navigate()

        val loggedInUser: User? = userManagement.loggedInUser
        if(loggedInUser != null) {
            val userId: Int = loggedInUser.id
            if (loggedInUser.name != null) {
                println(outputDesigner.getModifiedString(" Welcome ${loggedInUser.name} ",'-'))
            }
            else {
                println(outputDesigner.getModifiedString(" Welcome ",'-'))
            }

            while (true) {
                val categoryId: Int = mainMenu.navigateAndGetChoice(userId)
                if (categoryId == -1) {
                    userManagement.logoutUser(userId)
                    println(StringConstant.logoutMessage)
                    continue@outer
                }

                val choice: Int = bookmarkMenu.navigateAndGetChoice(categoryId)
                if(choice == -1) {
                    userManagement.logoutUser(userId)
                    println(StringConstant.logoutMessage)
                    continue@outer
                }
                if(choice == -2) continue
            }
        }
        break
    }

}