package com.example.rickandmorty.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.local.CharacterEntity
import com.example.rickandmorty.domain.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MainState(
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    val characters: List<CharacterEntity> = emptyList()
)

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private val mutableStateFlow = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = mutableStateFlow

    fun loadCharacters() {
        viewModelScope.launch(Dispatchers.Main) {
            characterRepository.fetchCharacters().collect{
                mutableStateFlow.value = mutableStateFlow.value.copy(
                    characters = it
                )
            }
        }
    }
}


