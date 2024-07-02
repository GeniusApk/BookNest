package com.geniusapk.booknest.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geniusapk.booknest.common.BookModel
import com.geniusapk.booknest.common.ResultState
import com.geniusapk.booknest.domain.repo.AllBookRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModel @Inject constructor(val repo: AllBookRepo) : ViewModel() {
    private val _state: MutableState<ItemsState> = mutableStateOf(ItemsState())
    val state: MutableState<ItemsState> = _state

    init {
        viewModelScope.launch {
            repo.getAllBooks().collect {
                when (it) {
                    is ResultState.Error -> {
                        _state.value = ItemsState(error = it.exception.localizedMessage)
                    }

                    ResultState.Loading -> {
                        _state.value = ItemsState(isLoading = true)
                    }

                    is ResultState.Success -> {
                        _state.value = ItemsState(items = it.data)
                    }
                }

            }
        }
    }

}


data class ItemsState(
    val isLoading: Boolean = false,
    val items: List<BookModel> = emptyList(),
    val error: String = ""

)