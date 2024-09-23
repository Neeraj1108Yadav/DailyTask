package com.nano.dailytask.ui

import Fashion
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nano.dailytask.listener.InsertProductListener
import com.nano.dailytask.listener.NetworkProductCallback
import com.nano.dailytask.repo.ProductRepository
import com.nano.dailytask.sealed.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

/**
 * Created By Neeraj Yadav on 13/09/24
 */
@HiltViewModel
class CosmeticViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val insertProductRepo : InsertProductListener
) : ViewModel(),NetworkProductCallback{

    fun getAllProducts(){
        viewModelScope.launch {
           if(productRepository.getProducts().isNotEmpty()){

           }else{
               // getting product from non-suspending function
               //networkProductRepo.getProducts(this@CosmeticViewModel)

               // getting product from suspending function
               val products = productRepository.getCosmeticProducts()
               onProductResponse(products)
           }
        }
    }

    private fun onProductResponse(result:NetworkResult<Fashion>){
        viewModelScope.launch(Dispatchers.IO) {
            when(result){
                is NetworkResult.Success ->{
                    val products = result.data.products.map {
                        insertProductRepo.getProductFromCosmetic(it)
                    }

                    val dimensions = result.data.products.map {
                        insertProductRepo.getDimensionFromCosmetic(it)
                    }

                    val reviews = result.data.products.map {
                        insertProductRepo.getReviewsFromCosmetic(it)
                    }

                    insertProductRepo.insertProducts(products)
                    insertProductRepo.insertDimensions(dimensions)
                    insertProductRepo.insertReviews(reviews.flatten())
                }
                is NetworkResult.Failure ->{

                }
                is NetworkResult.Loading ->{

                }
            }
        }
    }

    override fun onProductReceived(response: Response<Fashion>) {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

    override fun onError(t: Throwable) {

    }

    fun getAllProductFromRoom(){
        viewModelScope.launch {

        }
    }

    fun getAllReviewFromRoom(){
        viewModelScope.launch {

        }
    }

    fun getAllDimensionsFromRoom(){
        viewModelScope.launch {

        }
    }
}