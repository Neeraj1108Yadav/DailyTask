package com.nano.dailytask.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import okhttp3.Interceptor
import okhttp3.Response
import kotlin.jvm.Throws

/**
 * Created By Neeraj Yadav on 13/09/24
 */
class NetworkInterceptor(private val context: Context) : Interceptor{

    @Throws(NetworkConnectivityException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isNetworkConnectionAvailable()){
            throw NetworkConnectivityException("No Internet Connection")
        }

        val request = chain.request()
        val response = chain.proceed(request)
        return response
    }

    private fun isNetworkConnectionAvailable():Boolean{
        val connectionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectionManager.activeNetwork ?: false
        val activeNetwork = connectionManager.getNetworkCapabilities(network as? Network) ?: return false
        return activeNetwork.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}