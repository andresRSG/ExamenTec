package com.example.appexam.di

import android.app.Application
import com.example.appexam.data.core.JsonManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class JsonModule @Inject constructor(
){
    @Provides
    fun provideJsonManager(context: Application): JsonManager {
        return JsonManager(context)
    }
}