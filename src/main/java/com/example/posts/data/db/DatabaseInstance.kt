package com.example.posts.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.posts.data.model.PostItem

@Database(entities = [PostItem::class], version = 1, exportSchema = false)
abstract class DatabaseInstance : RoomDatabase() {
    abstract fun postdao(): PostDao

    companion object{
        private var DBINTANCE : DatabaseInstance? = null
        fun getDatabaseInstance(context: Context): DatabaseInstance{
            if(DBINTANCE == null){
                synchronized(context){
                    DBINTANCE = Room.databaseBuilder(context, DatabaseInstance::class.java, "postdatabase")
                        .build()
                }
            }
            return DBINTANCE!!
        }
    }
}