package com.example.posts.data.api

import com.example.posts.data.model.APIResponsePosts
import retrofit2.Response
import retrofit2.http.GET

interface PostApiService {
    @GET("/posts")
    suspend fun getAllPost(): Response<APIResponsePosts>
}
