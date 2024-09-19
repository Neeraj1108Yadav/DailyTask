package com.nano.dailytask.di

import android.content.Context
import com.nano.dailytask.api.ApiService
import com.nano.dailytask.constant.AppConstant
import com.nano.dailytask.network.NetworkConnectionInterceptor
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
* Created By Neeraj Yadav on 14/09/24
*/

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    private val BASE_URL = AppConstant.BASE_URL.toHttpUrl()

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit.Builder{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
    }

    @Singleton
    @Provides
    fun provideOkHttp(loggingInterceptor: HttpLoggingInterceptor,
                      networkConnectionInterceptor: NetworkConnectionInterceptor):OkHttpClient.Builder{
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addNetworkInterceptor(networkConnectionInterceptor)
            .addInterceptor(loggingInterceptor)
        return okHttpClient
    }

    @Singleton
    @Provides
    fun provideApiService(okhttp:OkHttpClient.Builder,
                          retrofit:Retrofit.Builder):ApiService{
        return retrofit.client(okhttp.build()).build().create(ApiService::class.java)
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
    fun getNetworkConnectionInterceptor(@ApplicationContext context: Context):NetworkConnectionInterceptor{
        return NetworkConnectionInterceptor(context)
    }
}