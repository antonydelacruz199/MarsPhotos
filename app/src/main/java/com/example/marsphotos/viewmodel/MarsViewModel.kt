package com.example.marsphotos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsphotos.data.repository.MarsRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Gestiona el estado de la pantalla. Recibe el repositorio, no Retrofit.
 */
class MarsViewModel(
    private val repository: MarsRepository
) : ViewModel() {

    // StateFlow expone el estado actual y cada cambio a la UI.
    private val _uiState = MutableStateFlow<MarsUiState>(MarsUiState.Loading)

    val uiState: StateFlow<MarsUiState> = _uiState.asStateFlow()

    init {
        getMarsPhotos()
    }

    fun getMarsPhotos() {
        // viewModelScope se cancela solo cuando el ViewModel se destruye.
        viewModelScope.launch {
            _uiState.value = MarsUiState.Loading

            try {
                val photos = repository.getMarsPhotos()
                _uiState.value = MarsUiState.Success(photos)
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                _uiState.value = MarsUiState.Error(
                    e.message ?: "Error al obtener los datos"
                )
            }
        }
    }
}
