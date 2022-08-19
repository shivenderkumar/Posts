package com.example.posts.di

import android.app.Application

class PostApplication : Application(){
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().dBModule(DBModule(applicationContext)).build()
    }
}