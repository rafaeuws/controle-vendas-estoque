package com.app.vendasestoque.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.vendasestoque.R
import com.app.vendasestoque.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnProducts.setOnClickListener {
            startActivity(Intent(this, ProductActivity::class.java))
        }

        binding.btnSales.setOnClickListener {
            startActivity(Intent(this, SalesActivity::class.java))
        }
    }
}
