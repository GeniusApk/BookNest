package com.geniusapk.booknest.presentation.CategoryScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material3.Text
import androidx.navigation.NavHostController
import com.geniusapk.booknest.presentation.ViewModel.CategoryViewModel
import com.geniusapk.booknest.presentation.component.EachCardCategory
import com.geniusapk.booknest.presentation.component.categoryShimmer


@Composable
fun CategoryScreen(viewModel: CategoryViewModel = hiltViewModel(), navHostController: NavHostController) {
//    LaunchedEffect(Unit) {
//        viewModel.loadCategories()
//    }



    Column(
        modifier = Modifier.fillMaxSize(),

        ) {
   //     val res = viewModel.state.value.category

//
//        LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
//            items(res) {
//                EachCardCategory(
//                    Category = it.name,
//                    navHostController = navHostController,
//                    imageUrl = it.categoryImageUrl,
//
//                )
//
//            }
//        }

        val res = viewModel.state.value

        when {
            res.isLoading -> {

                Column(modifier = Modifier.fillMaxSize()) {
                    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()){
                        items(10) {
                            categoryShimmer()
                        }
                    }
                }
            }

            res.error.isNotEmpty() -> {

                Text(text = res.error)
            }

            res.category.isNotEmpty() -> {
                Column(modifier = Modifier.fillMaxSize()) {
                    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
                        items(res.category) {
                            EachCardCategory(
                                Category = it.name,
                                navHostController = navHostController,
                                imageUrl = it.categoryImageUrl,

                                )

                        }
                    }
                }
            }

            else -> {

                Text(text = "No books available")
            }
        }




    }

}