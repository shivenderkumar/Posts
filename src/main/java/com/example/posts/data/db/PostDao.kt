package com.example.posts.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.posts.data.model.PostItem

@Dao
interface PostDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertPost(post: ArrayList<PostItem>)

    @Query("SELECT * FROM post")
    suspend fun getAllPost() :List<PostItem>
}
