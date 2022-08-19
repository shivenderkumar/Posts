package com.example.posts.di

import com.example.posts.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,DBModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}