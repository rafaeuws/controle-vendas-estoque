package com.app.vendasestoque.models

data class Sale(
    val id: String? = null,
    val productName: String = "",
    val quantity: Int = 0,
    val totalPrice: Double = 0.0
)
