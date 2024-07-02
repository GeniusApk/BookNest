package com.geniusapk.booknest.presentation.BookByCategory

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.geniusapk.booknest.presentation.ViewModel
import com.geniusapk.booknest.presentation.component.AnimatedShimmer
import com.geniusapk.booknest.presentation.component.EachCardBook


@Composable
fun BooksByCategory(category: String, viewModel: ViewModel = hiltViewModel(), navHostController: NavHostController) {
    LaunchedEffect(Unit) {
        viewModel.loadBooksByCategory( category)
    }






    val res = viewModel.state.value



    when {
        res.isLoading -> {

            AnimatedShimmer()
        }

        res.error.isNotEmpty() -> {

            Text(text = res.error)
        }

        res.items.isNotEmpty() -> {
            Column(modifier = Modifier) {
                LazyColumn(modifier = Modifier) {
                    items(res.items) {
                        EachCardBook(
                            imageUrl = it.bookImage,
                            title = it.bookName,
                            author = it.bookAuthor,
                            description = it.bookDescription,
                            navHostController = navHostController,
                            bookUrl = it.bookUrl

                        )
                    }


                }
            }
        }

        else -> {

            Text(text = "No books available",)
        }
    }



}