package com.example.marsphotos.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.marsphotos.data.repository.MarsRepository

/**
 * Construye [MarsViewModel] con su [MarsRepository].
 * Sustituye a un framework de inyección de dependencias en este ejercicio.
 */
class MarsViewModelFactory(
    private val repository: MarsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(MarsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MarsViewModel(repository) as T
        }
        throw IllegalArgumentException("Clase de ViewModel desconocida: ${modelClass.name}")
    }
}
