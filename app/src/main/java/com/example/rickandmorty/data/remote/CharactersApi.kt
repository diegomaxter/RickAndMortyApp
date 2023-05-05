package com.example.rickandmorty.data.remote

import retrofit2.http.GET

interface CharactersApi {
    @GET("/api/character")
    suspend fun fetchCharacters(): Response
}
