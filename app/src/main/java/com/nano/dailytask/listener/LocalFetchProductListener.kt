package com.nano.dailytask.listener

import com.nano.dailytask.model.Product
import com.nano.dailytask.model.ProductWithDimension
import com.nano.dailytask.model.ProductWithDimensionAndReview
import com.nano.dailytask.model.ProductWithReviews
import com.nano.dailytask.model.ReviewTable

/**
 * Created By Neeraj yadav on 17/09/24
 */
interface LocalFetchProductListener {

    suspend fun getProducts() : List<Product>
    suspend fun getProductById(id:Int) : List<Product>
    suspend fun getProductWithReviews() : List<ProductWithReviews>
    suspend fun getProductWithDimension() : List<ProductWithDimension>
    suspend fun getProductReviews(productId:Int) : List<ReviewTable>
    suspend fun getProductWithReviewAndDimension() : List<ProductWithDimensionAndReview>
}