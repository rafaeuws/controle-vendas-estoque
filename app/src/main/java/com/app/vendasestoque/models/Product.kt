package com.app.vendasestoque.models

data class Product(
    val id: String? = null,
    val name: String = "",
    val price: Double = 0.0,
    val quantity: Int = 0
)
