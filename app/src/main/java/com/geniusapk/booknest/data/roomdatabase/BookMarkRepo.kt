package com.geniusapk.booknest.data.roomdatabase

import javax.inject.Inject

class BookmarkRepository @Inject constructor(private val bookmarkDao: BookmarkDao) {
    suspend fun addBookmark(bookmark: booksRoomModel) {
        bookmarkDao.insertBookmark(bookmark)
    }

    suspend fun getBookmarksForBook(bookUrl: String): List<booksRoomModel> {
        return bookmarkDao.getBookmarksForBook(bookUrl)
    }

    suspend fun deleteBookmark(bookmark: booksRoomModel) {
        bookmarkDao.deleteBookmark(bookmark)
    }
    suspend fun getAllBookmarks(): List<booksRoomModel> {
        return bookmarkDao.getAllBookmarks()
    }
}