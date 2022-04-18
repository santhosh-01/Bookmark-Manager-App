package core

class CategoryManagement(private val categoryList: CategoryList) {

    fun addCategory(userId: Int, category: Category) {
        categoryList.addCategory(userId, category)
    }

    fun getAllCategories(userId: Int): Map<Int, Category>? {
        return categoryList.getCategoriesMap(userId)
    }

    fun getCategory(categoryId: Int): Category? {
        return categoryList.getCategory(categoryId)
    }

    fun updateCategoryName(categoryId: Int, newName: String) {
        val category: Category? = getCategory(categoryId)
        if (category != null) {
            category.name = newName
        }
    }

    fun updateCategoryDescription(categoryId: Int, newDescription: String) {
        val category: Category? = getCategory(categoryId)
        if (category != null) {
            category.description = newDescription
        }
    }

}