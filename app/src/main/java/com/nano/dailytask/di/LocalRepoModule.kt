package com.nano.dailytask.di

import com.nano.dailytask.listener.FetchProductListener
import com.nano.dailytask.repo.LocalProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created By Neeraj Yadav on 17/09/24
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class LocalRepoModule {

    @QualifierLocalRepo
    @Binds
    abstract fun bindProductRepository(
        localProductRepository: LocalProductRepository
    ) : FetchProductListener
}