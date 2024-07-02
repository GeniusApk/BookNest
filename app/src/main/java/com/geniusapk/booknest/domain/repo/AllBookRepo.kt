package com.geniusapk.booknest.domain.repo

import com.geniusapk.booknest.common.BookCategoryModel
import com.geniusapk.booknest.common.BookModel
import com.geniusapk.booknest.common.ResultState
import kotlinx.coroutines.flow.Flow

interface AllBookRepo {
    fun getAllBooks(): Flow<ResultState<List<BookModel>>>
    fun getAllCategories(): Flow<ResultState<List<BookCategoryModel>>>
     fun getAllBooksByCategory(category: String): Flow<ResultState<List<BookModel>>>

}