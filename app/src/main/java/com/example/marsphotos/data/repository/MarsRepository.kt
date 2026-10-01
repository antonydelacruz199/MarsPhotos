package com.example.marsphotos.data.repository

import com.example.marsphotos.data.model.MarsPhoto
import com.example.marsphotos.data.remote.MarsApiService

/**
 * Única capa que habla con [MarsApiService].
 * El ViewModel pide fotos aquí y no conoce Retrofit.
 */
class MarsRepository(
    private val apiService: MarsApiService
) {

    suspend fun getMarsPhotos(): List<MarsPhoto> {
        return apiService.getPhotos()
    }
}
