package com.sps.data.di

import android.content.Context
import androidx.room.Room
import com.sps.data.datastore.TodoDataStore
import com.sps.data.datastore.TodoDataStoreImpl
import com.sps.data.db.TodoDao
import com.sps.data.db.TodoDatabase
import com.sps.data.repository.TodoRepositoryImpl
import com.sps.domain.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTodoDatabase(@ApplicationContext context:
                            Context) = Room.databaseBuilder(context,TodoDatabase::class.java,"to_do").build()

    @Singleton
    @Provides
    fun provideTodoDao(database: TodoDatabase) = database.getTodoDao()

    @Singleton
    @Provides
    fun provideTodoRepository(dataStore: TodoDataStore) : TodoRepository {
      return  TodoRepositoryImpl(dataStore)
    }

    @Singleton
    @Provides
    fun provideTodoDataStore(tadoDao: TodoDao) : TodoDataStore {
      return  TodoDataStoreImpl(tadoDao)
    }




}