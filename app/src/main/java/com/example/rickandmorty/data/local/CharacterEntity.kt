package com.example.rickandmorty.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Origin(
    val originId: String = UUID.randomUUID().toString(),
    val nameOrigin: String,
    val url: String
)

@Entity
data class CharacterEntity(
    @PrimaryKey val id: String,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val image: String,
    val gender: String,
    @Embedded
    val origin: Origin
)
