package com.example.shoppinglist.repository

import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.data.entity.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDap().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDap().delete(item)

    fun getAll() = db.getShoppingDap().getAll()
}