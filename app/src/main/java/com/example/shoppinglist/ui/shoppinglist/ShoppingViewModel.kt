package com.example.shoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.entity.ShoppingItem
import com.example.shoppinglist.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAll() = repository.getAll()

}