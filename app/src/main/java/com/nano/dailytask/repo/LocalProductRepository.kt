package com.nano.dailytask.repo

import com.nano.dailytask.db.ProductDao
import com.nano.dailytask.listener.FetchProductListener
import com.nano.dailytask.model.Product
import javax.inject.Inject

/**
 * Created By Neeraj Yadav on 17/09/24
 */
class LocalProductRepository @Inject constructor(
    private val productDao: ProductDao
) : FetchProductListener {

    override suspend fun getProducts(): List<Product> {
       return productDao.getAllProducts()
    }

    override suspend fun getProductById(id: Int): List<Product> {
       return listOf()
    }
}