package com.example.myspecial.application

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myspecial.application.data.Product
import com.example.myspecial.application.data.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

private const val TAG = "MainViewModel"

class MainViewModel(private val productRepository: ProductRepository) : ViewModel() {

    private val _product = MutableStateFlow(emptyList<Product>())
    val product : StateFlow<List<Product>> = _product

    init {

        val data =  productRepository.getProduct(fileName = "olive_oils_data.json")
        data?.let {
           _product.value = it
        }

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
