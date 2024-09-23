package com.nano.dailytask.di

import com.nano.dailytask.listener.InsertProductListener
import com.nano.dailytask.repo.InsertProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created By Neeraj Yadav on 23/09/24
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class InsertProductModule {

    @Binds
    abstract fun bindInsertProductRepository(insertProductRepository: InsertProductRepository):InsertProductListener
}