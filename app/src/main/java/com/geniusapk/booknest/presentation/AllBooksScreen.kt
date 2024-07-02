package com.geniusapk.booknest.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.geniusapk.booknest.common.ResultState

@Composable
fun AllBooksScreen(modifier: Modifier= Modifier , viewModel: ViewModel = hiltViewModel()) {

    val res  = viewModel.state.value
//    if (res.isLoading){
//    }


    when {
        res.isLoading -> {

            CircularProgressIndicator(modifier = modifier)
        }
        res.error.isNotEmpty() -> {

            Text(text = res.error, modifier = modifier)
        }
        res.items.isNotEmpty() -> {
            Column(modifier = modifier) {
                res.items.forEach { book ->
                    Text(text = book.bookName)
                }
            }
        }
        else -> {

            Text(text = "No books available", modifier = modifier)
        }
    }



}