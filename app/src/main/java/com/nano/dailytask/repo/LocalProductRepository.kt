package com.nano.dailytask.repo

import com.nano.dailytask.db.ProductDao
import com.nano.dailytask.listener.LocalFetchProductListener
import com.nano.dailytask.model.Product
import com.nano.dailytask.model.ProductWithDimension
import com.nano.dailytask.model.ProductWithDimensionAndReview
import com.nano.dailytask.model.ProductWithReviews
import com.nano.dailytask.model.ReviewTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created By Neeraj Yadav on 17/09/24
 */
class LocalProductRepository @Inject constructor(
    private val productDao: ProductDao
) : LocalFetchProductListener {

    override suspend fun getProducts(): List<Product> {
       return withContext(Dispatchers.IO){
           productDao.getAllProducts()
       }
    }

    override suspend fun getProductById(id: Int): List<Product> {
       return listOf()
    }

    override suspend fun getProductWithReviews(): List<ProductWithReviews> {
        return productDao.getAllProductWithReviews()
    }

    override suspend fun getProductWithDimension(): List<ProductWithDimension> {
        return productDao.getAllProductWithDimension()
    }

    override suspend fun getProductReviews(productId: Int): List<ReviewTable> {
        return listOf()
    }

    override suspend fun getProductWithReviewAndDimension(): List<ProductWithDimensionAndReview> {
        return productDao.getAllProductWithReviewsAndDimensions()
    }
}