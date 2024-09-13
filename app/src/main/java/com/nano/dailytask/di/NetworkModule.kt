package com.nano.dailytask.di

import android.content.Context
import com.nano.dailytask.api.ApiService
import com.nano.dailytask.network.NetworkInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created By Neeraj Yadav on 13/09/24
 */

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    private val BASE_URL = "https://dummyjson.com/".toHttpUrl()

    @Singleton
    @Provides
    fun provideRetrofitBuilder():Retrofit.Builder{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
    }

    @Singleton
    @Provides
    fun provideApiService(
        retrofitBuilder:Retrofit.Builder,
        httpClient: OkHttpClient.Builder
    ) : ApiService{
        return retrofitBuilder.client(httpClient.build()).build().create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpBuilder(
        networkInterceptor: NetworkInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ):OkHttpClient.Builder{
        return OkHttpClient.Builder()
            .addNetworkInterceptor(networkInterceptor)
            .addNetworkInterceptor(loggingInterceptor)
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor():HttpLoggingInterceptor{
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideNetworkConnectionInterceptor(@ApplicationContext context: Context):NetworkInterceptor{
        return NetworkInterceptor(context)
    }
}