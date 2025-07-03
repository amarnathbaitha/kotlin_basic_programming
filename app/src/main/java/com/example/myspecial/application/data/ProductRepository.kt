package com.example.myspecial.application.data

import android.content.Context
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import androidx.compose.runtime.getValue
import retrofit2.Response
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ProductApi{
    @GET("products")
    suspend fun getProduct(): Response<List<Products>>
}
const val BASE_ENDPOINT_URL = "https://fakestoreapi.com/"

class ProductRepository(private val context: Context) {

    private val retrofit: Retrofit by lazy {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        Retrofit.Builder()
            .baseUrl(BASE_ENDPOINT_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }

    private val productApi: ProductApi by lazy {
        retrofit.create(ProductApi::class.java)
    }


    suspend fun getProduct():List<Products>{
        val response = productApi.getProduct()
        return if(response.isSuccessful) response.body().orEmpty() else emptyList()
    }
}