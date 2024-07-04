package com.geniusapk.booknest.presentation.AllBooksScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.geniusapk.booknest.presentation.ViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.geniusapk.booknest.presentation.component.AnimatedShimmer
import com.geniusapk.booknest.presentation.component.EachCardBook


@Composable
fun AllBooksScreen(
    modifier: Modifier = Modifier,
    viewModel: ViewModel = hiltViewModel(),
    navHostController: NavHostController
) {

//    LaunchedEffect(Unit) {
//        viewModel.loadBooks()
//    }


    val res = viewModel.state.value



    when {
        res.isLoading -> {
            Column(modifier = modifier.fillMaxSize()) {
                LazyColumn {
                    items(10) {
                        AnimatedShimmer()
                    }
                }
            }
        }

        res.error.isNotEmpty() -> {

            Text(text = res.error, modifier = modifier)
        }

        res.items.isNotEmpty() -> {
            Column(modifier = modifier.fillMaxSize()) {
                LazyColumn(modifier = modifier.fillMaxSize()) {
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

            Text(text = "No books available", modifier = modifier)
        }
    }


}