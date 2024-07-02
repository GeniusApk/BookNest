package com.geniusapk.booknest.data.network

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

class GetAllCategory @Inject constructor(val firebaseDatabase: FirebaseDatabase) {

    fun getAllCategories(){
        val categoryListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {



            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }
    }


}