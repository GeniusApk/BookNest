package com.geniusapk.booknest.presentation.ViewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geniusapk.booknest.common.BookCategoryModel
import com.geniusapk.booknest.common.BookModel
import com.geniusapk.booknest.common.ResultState
import com.geniusapk.booknest.domain.repo.AllBookRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel  @Inject constructor(val repo: AllBookRepo): ViewModel() {
    private val _state: MutableState<ItemsStateCate> = mutableStateOf(ItemsStateCate())
    val state: MutableState<ItemsStateCate> = _state


    init {
        viewModelScope.launch {
            repo.getAllCategories().collect {
                when (it) {
                    is ResultState.Error -> {
                        _state.value = ItemsStateCate(error = it.exception.localizedMessage)
                    }

                    ResultState.Loading -> {
                        _state.value = ItemsStateCate(isLoading = true)
                    }

                    is ResultState.Success -> {
                        _state.value = ItemsStateCate(category = it.data)
                    }
                }
            }


        }
    }
    }


data class ItemsStateCate(
    val isLoading: Boolean = false,
    val category : List<BookCategoryModel> = emptyList(),
    val items: List<BookModel> = emptyList(),
    val error: String = ""

)