package com.nano.dailytask.listener

import Fashion
import retrofit2.Response

/**
 * Created By Neeraj Yadav on 23/09/24
 */
interface NetworkProductCallback {
    fun onProductReceived(response: Response<Fashion>)
    fun onError(t:Throwable)
}