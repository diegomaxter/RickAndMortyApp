package com.example.rickandmorty.domain

import com.example.rickandmorty.data.local.CharacterEntity
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun fetchCharacters(): Flow<List<CharacterEntity>>
}


