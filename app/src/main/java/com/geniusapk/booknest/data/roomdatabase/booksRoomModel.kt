package com.geniusapk.booknest.data.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "bookmark_table")
data class booksRoomModel(
    @PrimaryKey(autoGenerate = true) var id: Int=0,
    var BookName: String,
    var BookAuthor: String,
    var BookUrl: String,
    var BookImage: String,
    var BookPage: Int,

    )