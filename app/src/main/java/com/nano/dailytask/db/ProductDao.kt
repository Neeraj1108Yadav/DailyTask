package com.nano.dailytask.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.nano.dailytask.model.DimensionsTable
import com.nano.dailytask.model.Product
import com.nano.dailytask.model.ProductWithDimension
import com.nano.dailytask.model.ProductWithDimensionAndReview
import com.nano.dailytask.model.ProductWithReviews
import com.nano.dailytask.model.ReviewTable

/**
 * Created By Neeraj Yadav on 13/09/24
 */
@Dao
interface ProductDao {

    @Insert
    fun insertProducts(product: Product)

    @Insert
    fun insertDimensions(dimensionsTable: DimensionsTable)

    @Insert
    fun insertReviews(reviewTable: ReviewTable)

    @Query("SELECT * FROM Product")
    fun getAllProducts() : List<Product>

    @Transaction
    @Query("SELECT * FROM Product")
    fun getAllProductWithDimension() : List<ProductWithDimension>

    @Transaction
    @Query("SELECT * FROM Product")
    fun getAllProductWithReviews() : List<ProductWithReviews>

    @Transaction
    @Query("SELECT * FROM Product")
    fun getAllProductWithReviewsAndDimensions() : List<ProductWithDimensionAndReview>
}