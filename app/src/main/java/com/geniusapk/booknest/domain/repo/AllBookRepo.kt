package com.geniusapk.booknest.domain.repo

import com.geniusapk.booknest.common.BookModel
import com.geniusapk.booknest.common.ResultState
import kotlinx.coroutines.flow.Flow

interface AllBookRepo {
    fun getAllBooks(): Flow<ResultState<List<BookModel>>>

}