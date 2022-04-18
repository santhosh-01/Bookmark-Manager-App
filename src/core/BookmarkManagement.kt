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

    fun updateBookmarkTitle(bookmarkId: Int, newTitle: String) {
        val bookmark: Bookmark? = getBookmark(bookmarkId)
        if (bookmark != null) {
            bookmark.title = newTitle
        }
    }

    fun updateBookmarkURL(bookmarkId: Int, newURL: String) {
        val bookmark: Bookmark? = getBookmark(bookmarkId)
        if (bookmark != null) {
            bookmark.url = newURL
        }
    }

    fun updateBookmarkDescription(bookmarkId: Int, newDescription: String) {
        val bookmark: Bookmark? = getBookmark(bookmarkId)
        if (bookmark != null) {
            bookmark.description = newDescription
        }
    }

}