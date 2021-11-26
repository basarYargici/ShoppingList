package com.example.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.data.entity.ShoppingItem
import com.example.shoppinglist.databinding.DialogAddShoppingItemBinding

class ShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {

    private lateinit var binding: DialogAddShoppingItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddShoppingItemBinding.inflate(layoutInflater)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val name = binding.etName.text?.toString()
            val amount = binding.etAmount.text?.toString()

            if (name?.isEmpty() == true || amount?.isEmpty() == true) {
                Toast.makeText(context, "Name and amount are necessary fields!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name!!, amount!!.toInt())
            addDialogListener.onAddButtonClick(item)
            dismiss()
        }

        binding.btnCancel.setOnClickListener {
            cancel()
        }
    }
}
