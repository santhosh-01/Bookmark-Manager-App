package core

class CategoryManagement(private val categoryList: CategoryList) {

    fun addCategory(userId: Int, category: Category) {
        categoryList.addCategory(userId, category)
    }

    fun getAllCategories(userId: Int): Map<Int, Category>? {
        return categoryList.getCategoriesMap(userId)
    }

}