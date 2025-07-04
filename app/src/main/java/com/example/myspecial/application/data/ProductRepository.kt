package com.example.myspecial.application.data

import android.content.Context
import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.io.File

interface ProductApi{
    @GET("products")
    suspend fun getProduct(): Response<List<Products>>
}
const val BASE_ENDPOINT_URL = "https://fakestoreapi.com/"
const val TAG = "ProductRepository"
class ProductRepository(private val context: Context) {


    private val moshi: Moshi by lazy{
        Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_ENDPOINT_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }

    private val productApi: ProductApi by lazy {
        retrofit.create(ProductApi::class.java)
    }

    private fun storeDataInFile(products: List<Products>){
        //deSerialized
        val listType = Types.newParameterizedType(List::class.java, Products::class.java)
        val fileContent = moshi.adapter<List<Products>>(listType).toJson(products)

        //val file = File(context.filesDir,"product.json")
        //Once you change to filesDir to cacheDir, After installing the app it will remove the storage data too.
        val file = File(context.cacheDir,"product.json")
        file.writeText(fileContent, charset = Charsets.UTF_8)

    }

    private fun readDataFromFile():List<Products>{
        val file = File(context.cacheDir,"product.json")
        val json = if(file.exists()) file.readText() else null

        return  if(json==null)
                emptyList()
        else{
            //Serialized
            val listType = Types.newParameterizedType(List::class.java, Products::class.java)
            moshi.adapter<List<Products>>(listType).fromJson(json).orEmpty()
        }


    }

    suspend fun getProduct():List<Products>{
        val productFromCache = readDataFromFile()
        if(productFromCache.isNotEmpty()){
            Log.d(TAG,"Load from the cache")
            return productFromCache
        }
        val response = productApi.getProduct()
        return if(response.isSuccessful) {
            Log.d(TAG,"Load from the Webservices")
            val product  = response.body()
                product?.let {
                    storeDataInFile(it)
                }
                product.orEmpty()
        }
        else emptyList()
    }
}