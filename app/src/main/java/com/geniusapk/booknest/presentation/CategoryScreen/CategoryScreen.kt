package com.geniusapk.booknest.presentation.CategoryScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.geniusapk.booknest.presentation.ViewModel
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.geniusapk.booknest.presentation.nav.Routes


@Composable
fun CategoryScreen(viewModel: ViewModel = hiltViewModel() , navHostController: NavHostController) {
    LaunchedEffect(Unit) {
        viewModel.loadCategories()
    }
    Column(
        modifier = Modifier.fillMaxSize(),

        ) {
        val res = viewModel.state.value.category

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(res) {
                Text(text = it.name , modifier = Modifier.clickable {
                    navHostController.navigate(Routes.BooksByCategory(it.name))

                })

            }
        }


    }

}