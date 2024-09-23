package com.nano.dailytask.sealed

/**
 * Created By Neeraj Yadav on 23/09/24
 */
sealed class NetworkResult<out T>{
    object Loading : NetworkResult<Nothing>()
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Failure(val message:String) : NetworkResult<Nothing>()
}