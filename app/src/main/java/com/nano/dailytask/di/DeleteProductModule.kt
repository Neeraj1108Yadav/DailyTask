package com.nano.dailytask.di

import com.nano.dailytask.listener.DeleteProductListener
import com.nano.dailytask.repo.DeleteProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DeleteProductModule {

    @Singleton
    @Binds
    abstract fun bindDeleteProductRepository(deleteProductRepository: DeleteProductRepository):DeleteProductListener
}