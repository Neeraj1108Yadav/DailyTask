package com.nano.dailytask.listener

import com.nano.dailytask.model.DimensionsTable
import com.nano.dailytask.model.Product
import com.nano.dailytask.model.ProductWithReviews
import com.nano.dailytask.model.ReviewTable

/**
 * Created By Neeraj Yadav on 23/09/24
 */
interface InsertProductListener {

    suspend fun insertProducts(products:List<Product>)
    suspend fun insertDimensions(dimension: List<DimensionsTable>)
    suspend fun insertReviews(reviews: List<ReviewTable>)
}