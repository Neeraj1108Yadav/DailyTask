package com.nano.dailytask.di

import com.nano.dailytask.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created By Neeraj Yadav on 24/09/24
 */
@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [NetworkModule::class]
)
class NetworkUnitTestModule {

    @Singleton
    @Provides
    fun provideRetrofit(mockWebServer: MockWebServer):Retrofit.Builder{
             return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(mockWebServer.url("/"))
    }

    @Singleton
    @Provides
    fun provideOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient.Builder{
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit:Retrofit.Builder,okHttpClient: OkHttpClient.Builder):ApiService{
        return retrofit.client(okHttpClient.build()).build().create(ApiService::class.java)
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
    fun provideMockWebServer():MockWebServer{
        return MockWebServer()
    }
}