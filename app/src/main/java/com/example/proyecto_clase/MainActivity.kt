package com.example.proyecto_clase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.proyecto_clase.ui.theme.ArtGalleryTheme
import com.example.proyecto_clase.viewmodel.PaintingViewModel

class MainActivity : ComponentActivity() {
    private val paintingViewModel: PaintingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryTheme {
                PaintingScreen(paintingViewModel)
            }
        }
    }
}