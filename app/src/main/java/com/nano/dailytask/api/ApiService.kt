package com.nano.dailytask.api

import Fashion
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created By Neeraj Yadav on 13/09/24
 */
interface ApiService {

    @GET("products")
    fun getProducts() : Call<Fashion>
}