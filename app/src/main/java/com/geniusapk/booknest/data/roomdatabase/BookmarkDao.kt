package com.geniusapk.booknest.data.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BookmarkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmark: booksRoomModel)

    @Query("SELECT * FROM bookmark_table WHERE BookUrl = :bookUrl")
    suspend fun getBookmarksForBook(bookUrl: String): List<booksRoomModel>

    @Delete
    suspend fun deleteBookmark(bookmark: booksRoomModel)

    @Query("SELECT * FROM bookmark_table ORDER BY id DESC")
    suspend fun getAllBookmarks(): List<booksRoomModel>


}