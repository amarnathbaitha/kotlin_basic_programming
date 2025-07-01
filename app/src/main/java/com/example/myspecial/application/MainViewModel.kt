package com.example.myspecial.application

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.myspecial.application.data.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val TAG = "MainViewModel"
private const val PRICE_PER_CAN_OF_OLIVES = 5

class MainViewModel : ViewModel() {

    private val _quantity = MutableStateFlow(0)
    val quantity: StateFlow<Int> = _quantity

    private val _totalAmount = MutableStateFlow(0)
    val totalAmount: StateFlow<Int> = _totalAmount

    init {
        val product = Product(
            name = "MilkBikies",
            imageFile = "Image",
            description = "This is the nice biscuit",
            size = 12,
            price = 25.0
        )
        Log.i(TAG, "initialized")
        Log.i(TAG,product.toString())
    }

    fun increaseQuantity() {
        _quantity.value += 1
    }

    fun decreaseQuantity() {
        if (_quantity.value > 0) _quantity.value -= 1
    }

    fun checkout() {
        _totalAmount.value = _quantity.value * PRICE_PER_CAN_OF_OLIVES
    }

}
