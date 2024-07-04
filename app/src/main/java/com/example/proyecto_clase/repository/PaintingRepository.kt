package com.example.proyecto_clase.repository


import com.example.proyecto_clase.model.Painting

class PaintingRepository {
    fun getPaintings(): List<Painting> {
        return listOf(
            Painting(1, "Starry Night", "A painting by Vincent van Gogh", "https://example.com/starrynight.jpg"),
            Painting(2, "Mona Lisa", "A painting by Leonardo da Vinci", "https://example.com/monalisa.jpg"),

        )
    }
}