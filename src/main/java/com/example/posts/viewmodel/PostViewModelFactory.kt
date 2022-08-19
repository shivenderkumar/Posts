package com.example.posts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.posts.domainlayer.repository.MainActivityRepository
import javax.inject.Inject

class PostViewModelFactory
@Inject constructor (private val mainActivityRepository: MainActivityRepository)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(mainActivityRepository) as T
    }
}