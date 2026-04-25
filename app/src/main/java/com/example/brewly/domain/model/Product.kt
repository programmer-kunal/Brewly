package com.example.brewly.domain.model

data class Product (
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageRes: Int
)