package com.nano.dailytask.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
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
    fun insertProducts(product: List<Product>)

    @Insert
    fun insertDimensions(dimensionsTable: List<DimensionsTable>)

    @Insert
    fun insertReviews(reviewTable: List<ReviewTable>)

    @Insert
    fun insertProduct(product: Product)

    @Insert
    fun insertDimension(dimensionsTable: DimensionsTable)

    @Insert
    fun insertReview(reviewTable: ReviewTable)

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

    @Query("DELETE FROM Product")
    fun deleteAllProducts()

    @Query("DELETE FROM Product WHERE id = :id")
    fun deleteProduct(id:Int)

    @Delete
    fun deleteProduct(product: Product)

    @Query("DELETE FROM ReviewTable WHERE productId = :id")
    fun deleteProductReviews(id:Int)

    @Query("DELETE FROM ReviewTable WHERE reviewId = :id")
    fun deleteReview(id:Int)

    @Query("DELETE FROM DimensionsTable WHERE productId = :id")
    fun deleteDimension(id:Int)

    @Transaction
    fun deleteProductRecord(id:Int){
        deleteDimension(id)
        deleteProductReviews(id)
        deleteProduct(id)
    }

    @Query("DELETE FROM REVIEWTABLE")
    fun deleteAllReviews()

    @Query("DELETE FROM DimensionsTable")
    fun deleteAllDimensions()
}