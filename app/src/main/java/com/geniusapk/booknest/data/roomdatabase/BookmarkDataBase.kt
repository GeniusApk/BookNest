package com.geniusapk.booknest.data.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [booksRoomModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao
}