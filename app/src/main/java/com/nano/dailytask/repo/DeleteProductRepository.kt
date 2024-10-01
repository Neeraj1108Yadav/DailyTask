package com.nano.dailytask.repo

import com.nano.dailytask.db.ProductDao
import com.nano.dailytask.listener.DeleteProductListener
import com.nano.dailytask.model.Product
import javax.inject.Inject

class DeleteProductRepository @Inject constructor(
    private val productDao: ProductDao
) : DeleteProductListener {

    override suspend fun deleteProduct(productId: Int) {
        productDao.deleteProduct(productId)
    }

    override suspend fun deleteProduct(product: Product) {
        productDao.deleteProduct(product)
    }

    override suspend fun deleteReviews(productId: Int) {
        productDao.deleteProductReviews(productId)
    }

    override suspend fun deleteDimension(productId: Int) {
        productDao.deleteDimension(productId)
    }

    override suspend fun deleteAllProducts() {
        productDao.deleteAllProducts()
    }

    override suspend fun deleteReview(reviewId: Int) {
       productDao.deleteReview(reviewId)
    }

    override suspend fun deleteProductReviewDimension(productId: Int) {
        productDao.deleteProductRecord(productId)
    }

    override suspend fun deleteAllReviews() {
        productDao.deleteAllReviews()
    }

    override suspend fun deleteAllDimensions() {
        productDao.deleteAllDimensions()
    }
}