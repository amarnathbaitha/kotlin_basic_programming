package com.example.myspecial.application

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

private const val TAG = "MainViewModel"

class MainViewModel : ViewModel() {

    private val _productImageId = MutableStateFlow(R.drawable.logo)
    val productImageId: StateFlow<Int> = _productImageId

    init {
        Log.i(TAG, "initialized")
    }

    fun generateNewImageId() {
        Log.i(TAG, "generateNewImageId")
        _productImageId.value = when(Random.nextInt(4)) {
            0 -> R.drawable.delicate_olive_oil
            1 -> R.drawable.lemon_olive_oil
            2 -> R.drawable.chili_olive_oil
            3 -> R.drawable.basil_olive_oil
            else -> R.drawable.logo
        }
    }
}
