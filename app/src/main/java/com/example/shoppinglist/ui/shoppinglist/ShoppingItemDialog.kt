package com.example.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.R
import com.example.shoppinglist.data.entity.ShoppingItem
import com.example.shoppinglist.databinding.DialogAddShoppingItemBinding

class ShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {

    private lateinit var binding: DialogAddShoppingItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)
        binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        val tvAdd2 = findViewById<TextView>(R.id.btnAdd)


        with(binding) {
            btnAdd.setOnClickListener {

                val name = etName.text.toString()
                val amount = etAmount.text.toString()

                if (name.isEmpty() || amount.isEmpty()) {
                    Toast.makeText(context, "Fill all info", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                val item = ShoppingItem(name, amount.toInt())
                addDialogListener.onAddButtonClick(item)
                dismiss()
            }

            btnCancel.setOnClickListener {
                cancel()
            }
        }
    }
}