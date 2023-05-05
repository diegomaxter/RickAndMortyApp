package com.example.rickandmorty.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao

interface CharacterDao {
    @Upsert
    suspend fun insertAll(entities: List<CharacterEntity>)

    @Query("SELECT * FROM CharacterEntity")
    suspend fun readAll():List<CharacterEntity>
}
