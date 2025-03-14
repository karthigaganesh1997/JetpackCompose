package com.example.jetpackcompose.domain.model

data class Product(
    val id: Int,
    val tittle:  String,
    val price: Double,
    val description: String,
    val category: String,
    val image:String)

data class  Rating(val rage: Double,
    val count: Int)
