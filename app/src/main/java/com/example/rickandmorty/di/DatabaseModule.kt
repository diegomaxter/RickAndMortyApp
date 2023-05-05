package com.example.rickandmorty.di

import android.content.Context
import com.example.rickandmorty.data.local.database.CharacterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): CharacterDatabase {
        return CharacterDatabase.buildDatabase(context)
    }
    @Provides
    fun provideDao(database: CharacterDatabase) = database.characterDao()
}
