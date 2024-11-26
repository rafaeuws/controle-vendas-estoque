package com.app.vendasestoque.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.vendasestoque.R
import com.app.vendasestoque.databinding.ActivitySalesBinding
import com.app.vendasestoque.models.Sale
import com.app.vendasestoque.database.FirebaseManager

class SalesActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySalesBinding
    private val salesList = mutableListOf<Sale>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySalesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadSales()

        binding.btnAddSale.setOnClickListener {
            // Lógica para adicionar uma nova venda
            // Pode incluir um diálogo para o usuário inserir os dados
        }
    }

    private fun setupRecyclerView() {
        binding.rvSales.layoutManager = LinearLayoutManager(this)
        binding.rvSales.adapter = SalesAdapter(salesList)
    }

    private fun loadSales() {
        FirebaseManager.getSales(onSuccess = { sales ->
            salesList.clear()
            salesList.addAll(sales)
            binding.rvSales.adapter?.notifyDataSetChanged()
        }, onFailure = {
            // Exibir mensagem de erro para o usuário
        })
    }
}
