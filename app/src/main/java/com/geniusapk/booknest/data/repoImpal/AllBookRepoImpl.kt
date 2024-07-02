package com.geniusapk.booknest.data.repoImpal

import android.util.Log
import com.geniusapk.booknest.common.BookCategoryModel
import com.geniusapk.booknest.common.BookModel
import com.geniusapk.booknest.common.ResultState
import com.geniusapk.booknest.domain.repo.AllBookRepo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AllBookRepoImpl @Inject constructor(val firebaseDatabase: FirebaseDatabase) : AllBookRepo {
    override fun getAllBooks(): Flow<ResultState<List<BookModel>>> = callbackFlow {

        trySend(ResultState.Loading)

        val valueEvent = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                var items: List<BookModel> = emptyList()

                items = snapshot.children.map { value ->

                    value.getValue<BookModel>()!!
                }

                trySend(ResultState.Success(items))
            }

            override fun onCancelled(error: DatabaseError) {

                trySend(ResultState.Error(error.toException()))
            }
        }

        firebaseDatabase.reference.child("Books").addValueEventListener(valueEvent)

        awaitClose {
            firebaseDatabase.reference.removeEventListener(valueEvent)
            close()
        }
    }

    override fun getAllCategories(): Flow<ResultState<List<BookCategoryModel>>> = callbackFlow {
        trySend(ResultState.Loading)

        val valueEvent = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                var items: List<BookCategoryModel> = emptyList()

                items = snapshot.children.map { value ->

                    value.getValue<BookCategoryModel>()!!
                }

                trySend(ResultState.Success(items))
            }

            override fun onCancelled(error: DatabaseError) {

                trySend(ResultState.Error(error.toException()))
            }
        }

        firebaseDatabase.reference.child("BookCategory").addValueEventListener(valueEvent)

        awaitClose {
            firebaseDatabase.reference.removeEventListener(valueEvent)
            close()
        }
    }

    override fun getAllBooksByCategory( category: String): Flow<ResultState<List<BookModel>>> = callbackFlow {

        trySend(ResultState.Loading)

        val valueEvent = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                var items: List<BookModel> = emptyList()

                items = snapshot.children.filter {
                    it.getValue<BookModel>()!!.Category == category
                }.map { value ->

                    value.getValue<BookModel>()!!
                }

                trySend(ResultState.Success(items))
            }

            override fun onCancelled(error: DatabaseError) {

                trySend(ResultState.Error(error.toException()))
            }
        }
        firebaseDatabase.reference.child("Books").addValueEventListener(valueEvent)

        awaitClose {
            firebaseDatabase.reference.removeEventListener(valueEvent)
            close()
        }
    }
}