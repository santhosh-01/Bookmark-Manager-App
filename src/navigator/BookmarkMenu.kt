package navigator

import core.Bookmark
import core.BookmarkManagement
import core.StringConstant
import util.OutputDesigner

class BookmarkMenu(private val bookmarkManagement: BookmarkManagement) {

    private val outputDesigner: OutputDesigner = OutputDesigner(172)

    private fun showMenu() {
        println(outputDesigner.getCharLine('#'))
        println("\nBookmark Menu")
        println("1. Add Bookmark")
        println("2. View Bookmark")
        println("3. Go to Main Menu")
        println("4. Logout")
        println(outputDesigner.getCharLine('#'))
    }

    fun navigateAndGetChoice(catId: Int): Int {
        outer@while (true) {
            showMenu()
            val choice: Int = validateAndGetChoice()
            if(choice == -1) continue
            if(choice == 1) {
                var title: String
                var url: String
                var description: String
                while (true) {
                    print("\nEnter URL Title ['b' for back] : ")
                    title = readLine().toString()
                    if (title == "b") continue@outer
                    if (title == "") {
                        println(StringConstant.emptyInputMessage)
                        continue
                    }
                    break
                }
                while (true) {
                    print("\nEnter URL : ")
                    url = readLine().toString()
                    if (url == "") {
                        println(StringConstant.emptyInputMessage)
                        continue
                    }
                    break
                }
                while (true) {
                    print("\nEnter Description ['s' for skip] : ")
                    description = readLine().toString()
                    if(description == "") {
                        println(StringConstant.emptyInputMessage)
                        continue
                    }
                    break
                }
                val bookmark: Bookmark = if(description == "s") Bookmark(title,url)
                else Bookmark(title,url,description)
                bookmarkManagement.addBookmark(catId,bookmark)
                println("\nNew Bookmark added successfully")
            }
            else if (choice == 2) {
                var bookmarksMap: Map<Int, Bookmark>? = bookmarkManagement.getAllBookmarks(catId)
                if (bookmarksMap == null) {
                    println("\nNo bookmarks are available")
                    continue
                }
                while (true) {
                    println(outputDesigner.getModifiedString(" Bookmarks ",'*'))
                    println()
                    for ((bookmarkId, bookmark) in bookmarksMap) {
                        println("Bookmark Id : $bookmarkId, Bookmark Title : ${bookmark.title}")
                    }
                    print("\nSelect any of the above bookmark id ['b' for back] : ")
                    val bookmarkIdString: String = readLine().toString()
                    if(bookmarkIdString == "b") break
                    val bookmarkId: Int
                    try {
                        bookmarkId = Integer.parseInt(bookmarkIdString)
                    }
                    catch (e: Exception) {
                        println(StringConstant.nonIntegerMessage)
                        continue
                    }
                    val bookmark: Bookmark? = bookmarksMap[bookmarkId]
                    if(bookmark == null) {
                        println(StringConstant.invalidBookmarkId)
                        continue
                    }
                    print("\nBookmark id : ${bookmark.id}, URL : ${bookmark.url}")
                    val desc: String? = bookmark.description
                    if(desc != null) {
                        print(", Description: $desc")
                    }
                    println()
                    break
                }
            }
            else if(choice == 3) {
                return -2
            }
            else if(choice == 4) {
                return -1
            }
        }
    }

    private fun validateAndGetChoice(): Int {
        print("\nEnter your choice : ")
        val choice: Int
        try {
            choice = Integer.parseInt(readLine())
        }
        catch (e: Exception) {
            println("\nYou have entered non integers! Please Enter Valid choice (1 to 4) ")
            return -1
        }
        if(choice < 1 || choice > 4) {
            println("\nGiven choice is Invalid! Please Enter Valid choice (1 to 4) ")
            return -1
        }
        return choice
    }
}