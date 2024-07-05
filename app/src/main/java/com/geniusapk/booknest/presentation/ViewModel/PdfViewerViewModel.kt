package com.geniusapk.booknest.presentation.ViewModel

import androidx.lifecycle.viewModelScope
import com.geniusapk.booknest.data.roomdatabase.BookmarkRepository
import com.geniusapk.booknest.data.roomdatabase.booksRoomModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.lifecycle.ViewModel


@HiltViewModel
class PdfViewerViewModel @Inject constructor(
    private val bookmarkRepository: BookmarkRepository
) : ViewModel() {
    private val _bookmarks = MutableStateFlow<List<booksRoomModel>>(emptyList())
    val bookmarks: StateFlow<List<booksRoomModel>> = _bookmarks.asStateFlow()

    fun addBookmark(bookmark: booksRoomModel) {
        viewModelScope.launch {
            bookmarkRepository.addBookmark(bookmark)
            loadBookmarks(bookmark.BookUrl)
        }
    }

    fun loadBookmarks(bookUrl: String) {
        viewModelScope.launch {
            _bookmarks.value = bookmarkRepository.getBookmarksForBook(bookUrl)
        }
    }

    fun removeBookmark(bookmark: booksRoomModel) {
        viewModelScope.launch {
            bookmarkRepository.deleteBookmark(bookmark)
            loadBookmarks(bookmark.BookUrl)
        }
    }
}