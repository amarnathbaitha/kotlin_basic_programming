package com.example.myspecial.application

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.random.Random

private const val  TAG = "MainViewModel"

class MainViewModel : ViewModel() {
    init {
        Log.i(TAG,"initialized")
    }

    fun generateNewImageId(): Int{
        return when(Random.nextInt(4)){
             0 -> R.drawable.logo
             1 -> R.drawable.brand
             2 -> R.drawable.ic_stat_name
             3 -> R.drawable.mommy
            else -> R.drawable.mommy
        }
    }
}