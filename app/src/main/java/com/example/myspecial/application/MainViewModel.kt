package com.example.myspecial.application

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myspecial.application.data.Product
import com.example.myspecial.application.data.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val TAG = "MainViewModel"
private const val PRICE_PER_CAN_OF_OLIVES = 5

class MainViewModel(private val productRepository: ProductRepository) : ViewModel() {

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
        val data =  productRepository.getTextFromTheResources(R.raw.olive_oils_data)
        Log.i(TAG, "initialized")
        Log.i(TAG, product.toString())
        Log.i(TAG,data)
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

class MainViewModelFactory(private val productRepository: ProductRepository): ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(productRepository)as T
        }
        throw IllegalArgumentException("Unknown View model class")
    }
}
