package com.example.posts.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "post")
data class PostItem(
    val body: String,
    @PrimaryKey
    val id: Int,
    val title: String,
    val userId: Int
)