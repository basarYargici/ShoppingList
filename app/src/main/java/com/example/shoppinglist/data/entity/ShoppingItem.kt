package com.example.shoppinglist.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_item")
data class ShoppingItem(
    val name: String,
    val amount: Int
) {
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
}