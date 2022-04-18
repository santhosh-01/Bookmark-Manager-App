package navigator

import core.Category
import core.CategoryManagement
import core.StringConstant
import util.OutputDesigner
import validation.IntegerValidator

class MainMenu(private val categoryManagement: CategoryManagement) {

    private val outputDesigner: OutputDesigner = OutputDesigner(172)

    private fun showMenu() {
        println(outputDesigner.getCharLine('#'))
        println("\nMain Menu")
        println("1. Add Bookmark Category")
        println("2. Go to Bookmark Category Menu")
        println("3. Logout")
        println(outputDesigner.getCharLine('#'))
    }

    fun navigateAndGetChoice(userId: Int): Int {
        outer@while (true) {
            showMenu()
            val choice: Int = IntegerValidator.validateInteger(1,3)
            if(choice == -1) continue
            if(choice == 1) {
                var categoryName: String
                var description: String
                while (true) {
                    print("\nEnter new bookmark category name ['b' for back] : ")
                    categoryName = readLine().toString()
                    if(categoryName == "b") continue@outer
                    if (categoryName == "") {
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
                val category: Category = if(description == "s") Category(categoryName)
                else Category(categoryName,description)
                categoryManagement.addCategory(userId, category)
                println("\nNew Category added successfully")
            }
            else if (choice == 2) {
                val categoriesMap: Map<Int, Category>? = categoryManagement.getAllCategories(userId)
                if(categoriesMap == null) {
                    println("\nNo Bookmark Categories are available")
                    continue
                }
                while (true) {
                    println("\nBookmark Categories")
                    println()
                    for (category in categoriesMap) {
                        println("Category Id : ${category.key}, Category name : ${category.value.name}")
                    }
                    println(outputDesigner.getCharLine('#'))
                    print("\nSelect any of the above category id ['b' for back] : ")
                    val categoryIdString: String = readLine().toString()
                    if(categoryIdString == "b") break
                    val categoryId: Int
                    try {
                        categoryId = Integer.parseInt(categoryIdString)
                    }
                    catch (e: Exception) {
                        println(StringConstant.nonIntegerMessage)
                        continue
                    }
                    val category: Category? = categoriesMap[categoryId]
                    if(category == null) {
                        println(StringConstant.invalidCategoryId)
                        continue
                    }
                    print("\nCategory id : ${category.id}, Name : ${category.name}")
                    val desc: String? = category.description
                    if(desc != null) {
                        print(", Description: $desc")
                    }
                    println()

                    return category.id
                }
            }
            else if(choice == 3) return -1
        }
    }

}