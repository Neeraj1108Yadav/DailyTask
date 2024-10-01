package com.nano.dailytask.listener

import com.nano.dailytask.model.Product

interface DeleteProductListener {
    suspend fun deleteProduct(productId:Int)
    suspend fun deleteReviews(productId: Int)
    suspend fun deleteDimension(productId: Int)
    suspend fun deleteAllProducts()
    suspend fun deleteReview(reviewId:Int)
    suspend fun deleteProduct(product: Product)
    suspend fun deleteProductReviewDimension(productId: Int)
    suspend fun deleteAllReviews()
    suspend fun deleteAllDimensions()
}