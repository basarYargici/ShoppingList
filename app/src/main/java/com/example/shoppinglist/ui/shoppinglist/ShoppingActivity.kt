package com.example.shoppinglist.ui.shoppinglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.ShoppingDatabase
import com.example.shoppinglist.repository.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository = repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)
    }
}