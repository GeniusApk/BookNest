package com.geniusapk.booknest.presentation.nav

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    object Home


    @Serializable
    data class pdf(
        val ImageUrl: String,
    )

    @Serializable
    data class BooksByCategory(
        val category: String,
    )



}