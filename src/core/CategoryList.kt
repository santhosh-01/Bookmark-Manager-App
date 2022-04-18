package core

private var _categoryId: Int = 1001

class CategoryList {

    // Map<UserID, MutableMap<CatID, Category>>
    private var _userCategories: MutableMap<Int, MutableMap<Int, Category>> = HashMap()

    var userCategories: Map<Int, Map<Int, Category>> = _userCategories
        get() = _userCategories
        private set

    fun addCategory(userId: Int, category: Category) {
        if(userId !in _userCategories) {
            _userCategories[userId] = HashMap()
        }
        category.id = _categoryId
        _userCategories[userId]?.set(_categoryId, category)
        _categoryId ++
    }

    fun getCategoriesMap(userId: Int): Map<Int, Category>? {
        return _userCategories[userId]
    }

    fun getCategory(categoryId: Int): Category? {
        for (categories in _userCategories.values) {
            for ((catId, category) in categories) {
                if(catId == categoryId) {
                    return category
                }
            }
        }
        return null
    }

}