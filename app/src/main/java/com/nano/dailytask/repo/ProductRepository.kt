package com.nano.dailytask.repo

import Fashion
import com.nano.dailytask.listener.LocalFetchProductListener
import com.nano.dailytask.listener.NetworkFetchProductListener
import com.nano.dailytask.listener.NetworkProductCallback
import com.nano.dailytask.model.Product
import com.nano.dailytask.model.ProductWithDimension
import com.nano.dailytask.model.ProductWithDimensionAndReview
import com.nano.dailytask.model.ProductWithReviews
import com.nano.dailytask.model.ReviewTable
import com.nano.dailytask.sealed.NetworkResult
import javax.inject.Inject

/**
* Created By Neeraj Yadav on 23/09/24
*/

class ProductRepository @Inject constructor(
    private val localProductRepo: LocalFetchProductListener,
    private val networkProductRepo: NetworkFetchProductListener
):NetworkFetchProductListener,LocalFetchProductListener{

    // Network Functions
    override fun getProducts(networkCallback: NetworkProductCallback) {}

    override suspend fun getCosmeticProducts(): NetworkResult<Fashion> {
        return networkProductRepo.getCosmeticProducts()
    }

    // Local Database Functions
    override suspend fun getProducts(): List<Product> {
       return localProductRepo.getProducts()
    }

    override suspend fun getProductById(id: Int): List<Product> {
       return listOf()
    }

    override suspend fun getProductWithReviews(): List<ProductWithReviews> {
        return listOf()
    }

    override suspend fun getProductWithDimension(): List<ProductWithDimension> {
        return listOf()
    }

    override suspend fun getProductReviews(productId: Int): List<ReviewTable> {
        return listOf()
    }

    override suspend fun getProductWithReviewAndDimension(): List<ProductWithDimensionAndReview> {
        return listOf()
    }

}