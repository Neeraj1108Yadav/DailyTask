package com.nano.dailytask.listener

import Fashion
import com.nano.dailytask.sealed.NetworkResult
import retrofit2.Response

/**
 * Created By Neeraj Yadav on 23/09/24
 */
interface NetworkFetchProductListener {

    fun getProducts(networkCallback:NetworkProductCallback)
    suspend fun getCosmeticProducts() : NetworkResult<Fashion>
}