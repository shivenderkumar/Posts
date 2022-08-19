package com.example.posts.domainlayer.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.posts.data.api.PostApiService
import com.example.posts.data.db.PostDao
import com.example.posts.data.model.PostItem
import javax.inject.Inject

class MainActivityRepository @Inject constructor(
    private val postApiService: PostApiService,
    private val postDao: PostDao
) {
    private val postsMutableLiveData = MutableLiveData<ArrayList<PostItem>>()
    val postsLiveData: LiveData<ArrayList<PostItem>>
    get() = postsMutableLiveData

    suspend fun getPostlist(){
        getPostFromLocal()
    }

    suspend private fun getPostFromLocal() {
        getPostFromRemote()
    }

    suspend private fun getPostFromRemote() {
        val result = postApiService.getAllPost()
        var arr=ArrayList<PostItem>()
        if(result.isSuccessful && result.body() != null)
        {
//            Log.i("MYTAGRESULT","FROM API : "+result.body().toString())
            for(item in result.body()!!){
                arr.add(item)
                Log.i("MYTAGRESULT","FROM API : "+item.toString())
            }
            postDao.insertPost(arr)
//            postDao.insertPost(result.body()!!.results)
            postsMutableLiveData.postValue(arr)
        }
    }

}