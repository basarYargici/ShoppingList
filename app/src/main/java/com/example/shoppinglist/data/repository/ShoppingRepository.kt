package com.example.shoppinglist.data.repository

import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.entity.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAll() = db.getShoppingDao().getAll()
}