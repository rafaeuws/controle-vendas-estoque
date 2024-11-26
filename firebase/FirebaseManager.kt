package com.app.vendasestoque.database

import com.app.vendasestoque.models.Product
import com.app.vendasestoque.models.Sale
import com.google.firebase.firestore.FirebaseFirestore

object FirebaseManager {

    private val db = FirebaseFirestore.getInstance()

    fun getProducts(onSuccess: (List<Product>) -> Unit, onFailure: () -> Unit) {
        db.collection("products").get()
            .addOnSuccessListener { result ->
                val products = result.map { document ->
                    document.toObject(Product::class.java).apply {
                        id = document.id
                    }
                }
                onSuccess(products)
            }
            .addOnFailureListener {
                onFailure()
            }
    }

    fun addProduct(product: Product, onSuccess: () -> Unit, onFailure: () -> Unit) {
        db.collection("products").add(product)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFailure() }
    }

    fun getSales(onSuccess: (List<Sale>) -> Unit, onFailure: () -> Unit) {
        db.collection("sales").get()
            .addOnSuccessListener { result ->
                val sales = result.map { document ->
                    document.toObject(Sale::class.java).apply {
                        id = document.id
                    }
                }
                onSuccess(sales)
            }
            .addOnFailureListener {
                onFailure()
            }
    }

    fun addSale(sale: Sale, onSuccess: () -> Unit, onFailure: () -> Unit) {
        db.collection("sales").add(sale)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFailure() }
    }
}
