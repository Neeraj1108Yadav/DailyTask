package com.nano.dailytask.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nano.dailytask.model.Product

/**
 * Created By Neeraj Yadav on 13/09/24
 */
@Dao
interface ProductDao {

    @Insert
    fun insertProducts(product: Product)

    @Query("SELECT * FROM Product")
    fun getAllProducts() : LiveData<List<Product>>

    /*@Transaction
    @Query("SELECT * FROM Product")
    fun getAllProductWithDimension() : LiveData<List<ProductWithDimension>>

    @Transaction
    @Query("SELECT * FROM Product")
    fun getAllProductWithReviews() : LiveData<List<ProductWithReviews>>*/
}