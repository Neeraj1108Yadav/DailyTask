package com.nano.dailytask.repo

import Fashion
import android.util.Log
import com.nano.dailytask.api.ApiService
import com.nano.dailytask.constant.AppConstant
import com.nano.dailytask.listener.NetworkFetchProductListener
import com.nano.dailytask.listener.NetworkProductCallback
import com.nano.dailytask.model.CosmeticProducts
import com.nano.dailytask.sealed.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created By Neeraj Yadav on 17/09/24
 */
class NetworkProductRepository @Inject constructor(
    private val apiService: ApiService
) : NetworkFetchProductListener {

    /**
     * method getProducts(networkCallback: NetworkProductCallback) is not a suspend function where
     * NetworkProductCallback is an interface which consist of two methods
     * --> onProductReceived(response: Response<Fashion), --> onError(t: Throwable)
     *
     * Here I achieved to pass data from a repository class to ViewModel class without using
     * return object.
     *
     * If I write method as getProducts():List<CosmeticProducts>{
     *
     * ..some code to fetch data from network
     *
     * return listOfProduct
     * }
     *
     * This won't work because below product.enqueue runs in background. Till we get data from
     * network in background in onResponse(..call,..response) method, Main thread continue its
     * processing and return empty list of products in viewmodel class.
     *
     * To avoid this I used an interface implemented in ViewModel class and pass the reference
     * of view model inside getProducts(this@<ViewModelClassName>) to pass data from repo to
     * viewmodel class.
     *
     * But this approach is not good as in bigger project we might use more api call inside single
     * viewmodel class and then we have to create and so many interface to implement in viewmodel
     * class and pass reference.
     *
     * Better approach can be done via using Coroutines below in next method.
     */
    override fun getProducts(networkCallback: NetworkProductCallback){
       val products = apiService.getProducts()
       products.enqueue(object : Callback<Fashion> {

           override fun onResponse(call: Call<Fashion>, response: Response<Fashion>) {
               if(response.isSuccessful){

                   response.body()?.let {
                       networkCallback.onProductReceived(response)
                   }

               }
           }

           override fun onFailure(call: Call<Fashion>, t: Throwable) {
               Log.d(AppConstant.TAG,"Product : ${t.toString()}")
               networkCallback.onError(t)
           }
       })
    }

    /**
     * ABOVE CODE WITHOUT COROUTINE
     */

    /**
     * BELOW CODE WITH COROUTINE as function getCosmeticProducts() is suspended
     * Calling getCosmeticProduct() from viewmodelScope execute in main thread.
     * On using withContext() with Dispatchers as IO will execute the operation in
     * background and return the result.
     *
     * Every Api call and operation with Room database should be done in background.
     * Don't use the main thread to freeze UI.
     */

    override suspend fun getCosmeticProducts(): NetworkResult<Fashion> {
        return try{
             withContext(Dispatchers.IO){
                 val response = apiService.getCosmeticProducts()
                 if(response.isSuccessful && response.body() != null){
                     NetworkResult.Success(response.body()!!)
                 }else{
                     NetworkResult.Failure("Something went wrong")
                 }
            }
        }catch (e:Exception){
            NetworkResult.Failure(e.toString())
        }
    }

}