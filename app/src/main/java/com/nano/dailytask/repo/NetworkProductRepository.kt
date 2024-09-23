package com.nano.dailytask.repo

import com.nano.dailytask.api.ApiService
import com.nano.dailytask.listener.FetchProductListener
import com.nano.dailytask.model.Product
import javax.inject.Inject

/**
 * Created By Neeraj Yadav on 17/09/24
 */
class NetworkProductRepository @Inject constructor(
    private val apiService: ApiService
) : FetchProductListener {

    override suspend fun getProducts(): List<Product> {
        return listOf()
    }

    override suspend fun getProductById(id: Int): List<Product> {
        return listOf()
    }

}