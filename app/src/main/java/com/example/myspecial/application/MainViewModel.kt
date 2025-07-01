package com.example.myspecial.application

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myspecial.application.data.Product
import com.example.myspecial.application.data.ProductRepository

private const val TAG = "MainViewModel"

class MainViewModel(private val productRepository: ProductRepository) : ViewModel() {

    init {
        val product = Product(
            name = "MilkBikies",
            imageFile = "Image",
            description = "This is the nice biscuit",
            size = 12,
            price = 25.0
        )
        val data =  productRepository.getTextFromTheAssets(fileName = "olive_oils_data.json")
        Log.i(TAG, "initialized")
        Log.i(TAG, product.toString())
        Log.i(TAG,data)
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
