package com.geniusapk.booknest.data.di

import com.geniusapk.booknest.data.repoImpal.AllBookRepoImpl
import com.geniusapk.booknest.domain.repo.AllBookRepo
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    @Singleton
    fun provideFirebaseRealtimeDatabase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage{
        return FirebaseStorage.getInstance()

    }

    @Provides
    @Singleton
    fun provideRapo( firebaseDatabase: FirebaseDatabase): AllBookRepo{
        return AllBookRepoImpl(firebaseDatabase)
    }





}