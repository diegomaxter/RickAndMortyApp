package com.example.rickandmorty.di

import com.example.rickandmorty.data.DefaultCharacterRepository
import com.example.rickandmorty.data.local.CharacterDao
import com.example.rickandmorty.data.remote.CharactersApi
import com.example.rickandmorty.domain.CharacterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CharacterModule {
    @Singleton
    @Provides
    fun provideCharacterRepository(characterApi: CharactersApi, characterDao: CharacterDao): CharacterRepository =
        DefaultCharacterRepository(characterApi,characterDao)

    @Singleton
    @Provides
    fun provideCharacterApi(retrofit: Retrofit = provideRetrofit()): CharactersApi =
        retrofit.create(CharactersApi::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
