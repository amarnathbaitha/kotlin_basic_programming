package com.example.myspecial.application.data

import android.content.Context

class ProductRepository(private val context: Context) {

    fun getTextFromTheResources(resourceId: Int): String {
        return context.resources.openRawResource(resourceId).bufferedReader().use {
            it.readText()
        }
    }
}