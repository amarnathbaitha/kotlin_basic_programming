package com.example.myspecial.application

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myspecial.application.data.ProductRepository
import com.example.myspecial.application.data.Products
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel(private val productRepository: ProductRepository) : ViewModel() {

    private val _product = MutableStateFlow(emptyList<Products>())
    val product : StateFlow<List<Products>> = _product

    private val _selectedProduct = MutableStateFlow<Products?>(null)
    val selectedProduct: StateFlow<Products?> = _selectedProduct

    init {
        viewModelScope.launch {
            _product.value =  productRepository.getProduct()
            Log.i(TAG,_product.value.toString())
        }

    }

    fun selectedProduct(products: Products){
        _selectedProduct.value = products
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
