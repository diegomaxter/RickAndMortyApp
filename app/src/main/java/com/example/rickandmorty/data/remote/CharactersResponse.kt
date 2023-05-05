package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.local.CharacterEntity
import com.example.rickandmorty.data.local.Origin
import com.google.gson.annotations.SerializedName

data class OriginResponse(
    val name: String,
    val url: String
)

data class CharactersResponse(
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    val origin: OriginResponse
)

fun CharactersResponse.toCharacter() = CharacterEntity(
    id = this.id,
    name = this.name,
    status = this.status,
    species = this.species,
    type = this.type,
    image = this.image,
    gender = this.gender,

    origin = Origin(
         nameOrigin = this.origin.name,
        url = this.origin.url
    )
)
