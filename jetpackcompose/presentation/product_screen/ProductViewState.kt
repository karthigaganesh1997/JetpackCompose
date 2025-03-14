package com.example.jetpackcompose.presentation.product_screen

import coil.compose.AsyncImagePainter
import com.example.jetpackcompose.domain.model.Product
import java.lang.Error

data class ProductViewState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)
