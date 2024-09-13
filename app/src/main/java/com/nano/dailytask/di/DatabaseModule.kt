package com.nano.dailytask.di

import android.content.Context
import androidx.room.Room
import com.nano.dailytask.db.ProductDao
import com.nano.dailytask.db.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created By Neeraj Yadav on 13/09/24
 */

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun providedProductDatabase(@ApplicationContext context: Context):ProductDatabase{
        return Room.databaseBuilder(context,ProductDatabase::class.java,"cosmetics_db")
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideProductDao(productDatabase: ProductDatabase):ProductDao{
        return productDatabase.productDao()
    }

}