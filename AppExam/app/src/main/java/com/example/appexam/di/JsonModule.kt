package com.example.appexam.di

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.example.appexam.data.core.JsonManager
import com.example.appexam.data.core.UserPreferencesManager
import com.google.gson.Gson
import com.google.gson.GsonBuilder
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

    @Provides
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(app)
    }

    @Provides

    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideUsuarioRepository(sharedPreferences: SharedPreferences, gson: Gson): UserPreferencesManager {
        return UserPreferencesManager(sharedPreferences, gson)
    }

}