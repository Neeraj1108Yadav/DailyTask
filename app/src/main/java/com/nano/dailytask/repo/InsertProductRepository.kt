package com.nano.dailytask.repo

import com.nano.dailytask.db.ProductDao
import com.nano.dailytask.listener.InsertProductListener
import com.nano.dailytask.model.DimensionsTable
import com.nano.dailytask.model.Product
import com.nano.dailytask.model.ReviewTable
import javax.inject.Inject

/**
 * Created By Neeraj Yadav on 23/09/24
 */
class InsertProductRepository @Inject constructor(
    private val productDao: ProductDao
) : InsertProductListener{

    override suspend fun insertProducts(products: List<Product>) {

    }

    override suspend fun insertDimensions(dimension: List<DimensionsTable>) {

    }

    override suspend fun insertReviews(reviews: List<ReviewTable>) {

    }
}