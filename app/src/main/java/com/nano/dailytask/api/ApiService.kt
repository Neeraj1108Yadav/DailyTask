package com.nano.dailytask.api

import Fashion
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created By Neeraj Yadav on 13/09/24
 */
interface ApiService {

    @GET("products")
    fun getProducts() : Call<Fashion>

    @GET("products")
    suspend fun getCosmeticProducts() : Response<Fashion>
}