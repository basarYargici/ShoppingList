package com.example.shoppinglist.ui.shoppinglist

import com.example.shoppinglist.data.entity.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClick(item:ShoppingItem)
}