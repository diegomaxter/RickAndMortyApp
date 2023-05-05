package com.example.rickandmorty.data.remote

import com.example.rickandmorty.Info

data class Response(
    val info: Info,
    val results: List<CharactersResponse>
)
