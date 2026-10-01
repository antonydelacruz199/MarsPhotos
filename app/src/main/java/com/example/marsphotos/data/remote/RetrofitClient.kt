package com.example.marsphotos.data.remote

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

/**
 * Configura Retrofit una sola vez y expone [MarsApiService].
 * OkHttp llega de forma transitiva con Retrofit y es el cliente HTTP que usa por debajo.
 */
object RetrofitClient {

    private const val BASE_URL =
        "https://android-kotlin-fun-mars-server.appspot.com/"

    /**
     * ignoreUnknownKeys evita fallar si la API envía campos que MarsPhoto no declara.
     */
    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            json.asConverterFactory("application/json".toMediaType())
        )
        .build()

    val apiService: MarsApiService = retrofit.create(MarsApiService::class.java)
}
