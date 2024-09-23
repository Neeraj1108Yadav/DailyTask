package com.nano.dailytask.di

import com.nano.dailytask.listener.LocalFetchProductListener
import com.nano.dailytask.repo.LocalProductRepository
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
abstract class LocalRepoModule {

    @Singleton
    @Binds
    abstract fun bindProductRepository(
        localProductRepository: LocalProductRepository
    ) : LocalFetchProductListener
}