package com.example.proyecto_clase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto_clase.model.Painting
import com.example.proyecto_clase.repository.PaintingRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PaintingViewModel : ViewModel() {
    private val repository = PaintingRepository()
    private val _paintings = MutableStateFlow<List<Painting>>(emptyList())

    val paintings: StateFlow<List<Painting>> get() = _paintings

    init {
        loadPaintings()
    }

    private fun loadPaintings() {
        viewModelScope.launch {
            _paintings.value = repository.getPaintings()
        }
    }
}