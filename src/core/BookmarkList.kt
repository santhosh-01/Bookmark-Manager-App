package core

private var _bookmarkId: Int = 1001

class BookmarkList {

    // Map<catId, MutableMap<bookmarkId, URL>>
    private var _categoryBookmarks: MutableMap<Int, MutableMap<Int, Bookmark>> = HashMap()

    var catogoryBookmark: Map<Int, Map<Int, Bookmark>> = _categoryBookmarks
        get() = _categoryBookmarks
        private set

    fun addBookmark(catId: Int, bookmark: Bookmark) {
        if(catId !in _categoryBookmarks) {
            _categoryBookmarks[catId] = HashMap()
        }
        bookmark.id = _bookmarkId
        _categoryBookmarks[catId]?.set(_bookmarkId, bookmark)
        _bookmarkId ++
    }

    fun getBookmarksMap(catId: Int): Map<Int, Bookmark>? {
        return _categoryBookmarks[catId]
    }

    fun getBookmark(bookmarkId: Int): Bookmark? {
        for (bookmark in _categoryBookmarks.values) {
            for ((bookId, url) in bookmark) {
                if(bookId == bookmarkId) {
                    return url
                }
            }
        }
        return null
    }

}