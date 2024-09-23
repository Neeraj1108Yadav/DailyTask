package com.nano.dailytask.di

import com.nano.dailytask.listener.FetchProductListener
import com.nano.dailytask.repo.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created By Neeraj Yadav on 23/09/24
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class ProductRepoModule {

    @QualifierProductRepo
    @Binds
    abstract fun bindProductRepository(
        productRepository: ProductRepository
    ) : FetchProductListener
}