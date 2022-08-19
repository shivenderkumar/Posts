package com.example.posts.di

import com.example.posts.data.api.PostApiService
import com.example.posts.data.api.RetrofitInstance
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return RetrofitInstance.getRetrofitInstance()
    }

    @Singleton
    @Provides
    fun providesQuoteService(retrofit: Retrofit) : PostApiService{
        return retrofit.create(PostApiService::class.java)
    }

}