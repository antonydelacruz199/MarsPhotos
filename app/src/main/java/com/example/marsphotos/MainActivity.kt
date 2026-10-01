package com.example.marsphotos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.marsphotos.data.remote.RetrofitClient
import com.example.marsphotos.data.repository.MarsRepository
import com.example.marsphotos.ui.screens.HomeScreen
import com.example.marsphotos.ui.theme.MarsPhotosTheme
import com.example.marsphotos.viewmodel.MarsViewModel
import com.example.marsphotos.viewmodel.MarsViewModelFactory

class MainActivity : ComponentActivity() {

    // viewModels() conserva la misma instancia ante rotación de pantalla.
    // La factory solo se usa la primera vez que se crea el ViewModel.
    private val marsViewModel: MarsViewModel by viewModels {
        MarsViewModelFactory(
            MarsRepository(RetrofitClient.apiService)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MarsPhotosTheme {
                // collectAsState convierte el StateFlow en estado de Compose.
                val uiState by marsViewModel.uiState.collectAsState()

                HomeScreen(
                    uiState = uiState,
                    onRetry = marsViewModel::getMarsPhotos
                )
            }
        }
    }
}
