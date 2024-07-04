package com.example.proyecto_clase

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.proyecto_clase.model.Painting
import com.example.proyecto_clase.viewmodel.PaintingViewModel

@Composable
fun PaintingScreen(viewModel: PaintingViewModel = viewModel()) {
    val paintings by viewModel.paintings.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(paintings) { painting ->
            PaintingItem(painting)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PaintingItem(painting: Painting) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        GlideImage(
            model = painting.imageUrl,
            contentDescription = painting.title,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = painting.title, style = MaterialTheme.typography.titleMedium)
        Text(text = painting.description, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun PaintingItemPreview() {
    val painting = Painting(1, "Starry Night", "A painting by Vincent van Gogh", "https://example.com/starrynight.jpg")
    PaintingItem(painting)
}