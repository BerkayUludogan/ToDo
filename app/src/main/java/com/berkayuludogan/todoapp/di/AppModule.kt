package com.berkayuludogan.todoapp.di

import android.content.Context
import androidx.room.Room
import com.berkayuludogan.todoapp.core.Constants
import com.berkayuludogan.todoapp.data.datasource.TodoDataSource
import com.berkayuludogan.todoapp.data.repository.TodoRepository
import com.berkayuludogan.todoapp.room.MyDatabase
import com.berkayuludogan.todoapp.room.TodoDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Provides
    @Singleton
    fun provideTodoDAO(@ApplicationContext context: Context): TodoDAO {
        val db = Room.databaseBuilder(context, MyDatabase::class.java, Constants.DB_NAME)
            .createFromAsset(Constants.DB_ASSET_NAME)
            .build()
        return db.todoDAO()
    }

}