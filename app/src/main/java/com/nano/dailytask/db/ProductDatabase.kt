package com.nano.dailytask.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nano.dailytask.model.DimensionsTable
import com.nano.dailytask.model.Product
import com.nano.dailytask.model.ReviewTable

/**
 * Created By Neeraj Yadav on 13/09/24
 */
@Database(entities = [Product::class,ReviewTable::class,DimensionsTable::class], version = 1)
@TypeConverters(Converter::class)
abstract class ProductDatabase : RoomDatabase(){

    abstract fun productDao():ProductDao
}