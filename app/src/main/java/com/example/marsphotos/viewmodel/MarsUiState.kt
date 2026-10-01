package com.example.marsphotos.viewmodel

import com.example.marsphotos.data.model.MarsPhoto

/**
 * Estados posibles de la pantalla principal.
 * Success guarda la lista real para que la UI calcule photos.size.
 */
sealed interface MarsUiState {

    data object Loading : MarsUiState

    data class Success(
        val photos: List<MarsPhoto>
    ) : MarsUiState

    data class Error(
        val message: String
    ) : MarsUiState
}
