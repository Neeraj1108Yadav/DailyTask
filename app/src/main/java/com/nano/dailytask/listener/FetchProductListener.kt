package com.nano.dailytask.listener

import com.nano.dailytask.model.Product
import com.nano.dailytask.model.ProductWithDimension
import com.nano.dailytask.model.ProductWithDimensionAndReview
import com.nano.dailytask.model.ProductWithReviews

/**
 * Created By Neeraj yadav on 17/09/24
 */
interface FetchProductListener {

    suspend fun getProducts() : List<Product>
    suspend fun getProductById(id:Int) : List<Product>
}