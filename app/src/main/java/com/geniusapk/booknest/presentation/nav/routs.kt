package com.geniusapk.booknest.presentation.nav

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    object Home


    @Serializable
    data class pdf(
        val ImageUrl: String,
        val title: String,
        val author: String,
        val bookUrl: String,
        val page: Int = 0
    )

    @Serializable
    data class BooksByCategory(
        val category: String,
    )

    @Serializable
    object Bookmarks



}