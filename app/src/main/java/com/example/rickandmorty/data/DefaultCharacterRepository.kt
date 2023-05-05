package com.example.rickandmorty.data

import com.example.rickandmorty.data.local.CharacterDao
import com.example.rickandmorty.data.local.CharacterEntity
import com.example.rickandmorty.data.remote.CharactersApi
import com.example.rickandmorty.data.remote.toCharacter
import com.example.rickandmorty.domain.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DefaultCharacterRepository @Inject constructor(
    private val api: CharactersApi,
    private val dao: CharacterDao
) : CharacterRepository {

    override suspend fun fetchCharacters(): Flow<List<CharacterEntity>> {
        //muestro lo que está en base de datos local
        return flow {
            val entities = dao.readAll()
            emit(entities)
           try {
               val result = api.fetchCharacters().results.map { it.toCharacter() }
               if (result.isNotEmpty()) {
                   dao.insertAll(result)
                   emit(result)
               }
           } catch (ex:Exception) {
               ex.printStackTrace()
           }
        }.flowOn(Dispatchers.IO)
    }
}


