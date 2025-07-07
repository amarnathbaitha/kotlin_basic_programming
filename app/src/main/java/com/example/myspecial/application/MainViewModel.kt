package com.example.myspecial.application

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myspecial.application.data.ProductRepository
import com.example.myspecial.application.data.Products
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel(
    private val productRepository: ProductRepository
) : ViewModel() {
    private val _products = MutableStateFlow(emptyList<Products>())
    val products: StateFlow<List<Products>> = _products

    private val _selectedProduct = MutableStateFlow<Products?>(null)
    val selectedProduct: StateFlow<Products?> = _selectedProduct

    val quantity: StateFlow<Int> = productRepository.quantity
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = 0
        )

    init {
        viewModelScope.launch {
            _products.value = productRepository.getProduct()
            Log.i(TAG, _products.value.toString())
        }
    }

    fun selectProduct(product: Products) {
        _selectedProduct.value = product
    }

    fun incrementQuantity() {
        viewModelScope.launch {
            productRepository.incrementQuantity()
        }
    }

    fun decrementQuantity() {
        viewModelScope.launch {
            productRepository.decrementQuantity()
        }
    }

}

class MainViewModelFactory(
    private val productRepository: ProductRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(productRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}