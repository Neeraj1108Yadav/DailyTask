package com.nano.dailytask.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nano.dailytask.model.Dimensions
import com.nano.dailytask.model.Product
import com.nano.dailytask.model.Review

/**
 * Created By Neeraj Yadav on 13/09/24
 */
@Database(entities = [Product::class], version = 1)
@TypeConverters(Converter::class)
abstract class ProductDatabase : RoomDatabase(){

    abstract fun productDao():ProductDao
}