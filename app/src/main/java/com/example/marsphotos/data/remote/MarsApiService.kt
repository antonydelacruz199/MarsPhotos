package com.example.marsphotos.data.remote

import com.example.marsphotos.data.model.MarsPhoto
import retrofit2.http.GET

/**
 * Contrato HTTP de la API de fotos de Marte.
 * Retrofit implementa esta interfaz; la app no escribe la petición a mano.
 */
interface MarsApiService {

    /**
     * GET /photos.
     * suspend permite llamar a la red desde una corrutina sin bloquear el hilo principal.
     * Retrofit convierte el JSON en List<MarsPhoto> con kotlinx.serialization.
     */
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
