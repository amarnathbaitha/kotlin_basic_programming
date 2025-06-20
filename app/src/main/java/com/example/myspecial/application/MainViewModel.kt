package com.example.myspecial.application

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

private const val  TAG = "MainViewModel"

class MainViewModel : ViewModel() {

    private val _productImageId = MutableStateFlow(R.drawable.logo)
    val productImageId: StateFlow<Int> = _productImageId

    init {
        Log.i(TAG,"initialized")
    }

    fun generateNewImageId(){
        Log.i(TAG,"generateNewImageId")
        _productImageId.value  = when(Random.nextInt(4)){
             0 -> R.drawable.logo
             1 -> R.drawable.cat
             2 -> R.drawable.ic_stat_name
             3 -> R.drawable.mommy
            else -> R.drawable.mommy
        }
    }
}