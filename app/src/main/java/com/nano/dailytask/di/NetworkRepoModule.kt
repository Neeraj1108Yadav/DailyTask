package com.nano.dailytask.di

import com.nano.dailytask.listener.NetworkFetchProductListener
import com.nano.dailytask.repo.NetworkProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created By Neeraj Yadav on 17/09/24
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkRepoModule{

    @Singleton
    @Binds
    abstract fun bindProductRepository(
        networkProductRepository: NetworkProductRepository
    ) : NetworkFetchProductListener
}