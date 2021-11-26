package com.example.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.entity.ShoppingItem
import com.example.shoppinglist.databinding.ShoppingItemBinding
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ShoppingItemBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentItem = items[position]
        with(holder.binding) {
            tvName.text = currentItem.name
            tvAmount.text = currentItem.amount.toString()

            ivDelete.setOnClickListener {
                viewModel.delete(item = currentItem)
            }
            ivMinus.setOnClickListener {
                if (currentItem.amount > 0) {
                    currentItem.amount--
                    viewModel.upsert(item = currentItem)
                }
            }
            ivPlus.setOnClickListener {
                currentItem.amount++
                viewModel.upsert(item = currentItem)
            }
        }
    }

    override fun getItemCount(): Int = items.size
}