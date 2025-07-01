package com.example.myspecial.application.data

import android.content.Context
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class ProductRepository(private val context: Context) {

    fun getTextFromTheResources(resourceId: Int): String {
        return context.resources.openRawResource(resourceId).bufferedReader().use {
            it.readText()
        }
    }

    fun getTextFromTheAssets(fileName: String): String {
        //kotlin use function is to use the resources to be closed after this method.
        return context.resources.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
    }

    fun getProduct(fileName: String):List<Product>?{
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val listParameter = Types.newParameterizedType(List::class.java,Product::class.java)
        val adapter: JsonAdapter<List<Product>> = moshi.adapter<List<Product>>(listParameter)
        return  adapter.fromJson(getTextFromTheAssets(fileName))

    }
}