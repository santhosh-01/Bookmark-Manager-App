package core

class BookmarkManagement(private val bookmarkList: BookmarkList) {

    fun addBookmark(categoryId: Int, bookmark: Bookmark) {
        bookmarkList.addBookmark(categoryId,bookmark)
    }

    fun getBookmark(bookmarkId: Int): Bookmark? {
        return bookmarkList.getBookmark(bookmarkId)
    }

    fun getAllBookmarks(categoryId: Int): Map<Int, Bookmark>? {
        return bookmarkList.getBookmarksMap(categoryId)
    }

}