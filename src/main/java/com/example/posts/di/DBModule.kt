package com.example.posts.di

import android.content.Context
import com.example.posts.data.db.DatabaseInstance
import com.example.posts.data.db.PostDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule(val context: Context) {
    @Singleton
    @Provides
    fun provideDBInstance():DatabaseInstance{
        return  DatabaseInstance.getDatabaseInstance(context)
    }
    @Singleton
    @Provides
    fun providePostDao(databaseInstance: DatabaseInstance):PostDao{
        return  databaseInstance.postdao()
    }
}