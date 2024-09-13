package com.nano.dailytask.repo

import Fashion
import android.util.Log
import com.nano.dailytask.api.ApiService
import com.nano.dailytask.db.ProductDao
import com.nano.dailytask.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created By Neeraj Yadav on 13/09/24
 */
class ProductRepo @Inject constructor(private val productDao: ProductDao,
                                      private val apiService: ApiService) {

    fun getAllProduct(){
       val productCall = apiService.getProducts()
       productCall.enqueue(object : Callback<Fashion> {
           override fun onResponse(call: Call<Fashion>, response: Response<Fashion>) {
              if(response.isSuccessful){
                  response.body()?.products?.forEach {
                      Log.d("daily","Product : ${it}")
                      productDao.insertProducts(it)
                  }
              }
           }

           override fun onFailure(call: Call<Fashion>, t: Throwable) {
               Log.d("daily","Product : ${t.toString()}")
           }
       })
    }
}