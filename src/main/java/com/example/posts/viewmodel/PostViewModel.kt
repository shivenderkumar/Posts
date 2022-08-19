package com.example.posts.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.posts.MainActivity
import com.example.posts.data.model.PostItem
import com.example.posts.domainlayer.repository.MainActivityRepository
import kotlinx.coroutines.launch

class PostViewModel (private val mainActivityRepository: MainActivityRepository) : ViewModel(){
    val postsLiveData : LiveData<ArrayList<PostItem>>
        get() = mainActivityRepository.postsLiveData

    init {
        viewModelScope.launch {
            mainActivityRepository.getPostlist()
        }
    }
}