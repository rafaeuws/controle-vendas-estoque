package com.app.vendasestoque.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.vendasestoque.R
import com.app.vendasestoque.models.Sale
import kotlinx.android.synthetic.main.item_sale.view.*

class SaleAdapter(private val saleList: List<Sale>) : RecyclerView.Adapter<SaleAdapter.SaleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sale, parent, false)
        return SaleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SaleViewHolder, position: Int) {
        val sale = saleList[position]
        holder.bind(sale)
    }

    override fun getItemCount(): Int = saleList.size

    inner class SaleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(sale: Sale) {
            itemView.sale_total.text = "Total: R$ ${sale.total}"
            itemView.sale_date.text = "Data: ${sale.date}"
        }
    }
}
