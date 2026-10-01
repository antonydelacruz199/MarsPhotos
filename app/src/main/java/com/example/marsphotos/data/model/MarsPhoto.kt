package com.example.marsphotos.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Foto devuelta por la API de Marte.
 *
 * @Serializable indica a kotlinx.serialization que puede convertir
 * este objeto desde y hacia JSON.
 * @SerialName mapea la propiedad Kotlin [imgSrc] al campo JSON "img_src".
 */
@Serializable
data class MarsPhoto(
    val id: String,
    @SerialName("img_src")
    val imgSrc: String
)
