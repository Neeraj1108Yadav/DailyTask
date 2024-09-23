package com.nano.dailytask.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nano.dailytask.di.QualifierProductRepo
import com.nano.dailytask.listener.FetchProductListener
import com.nano.dailytask.repo.InsertProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created By Neeraj Yadav on 13/09/24
 */
@HiltViewModel
class CosmeticViewModel @Inject constructor(
   @QualifierProductRepo private val productRepo: FetchProductListener,
    private val insertProductRepo : InsertProductRepository
) : ViewModel(){

    fun getAllProducts(){
        //productRepo.getAllProduct()
        viewModelScope.launch {
            productRepo.getProducts()
        }
    }

    fun getAllProductFromRoom(){
        //productRepo.getAllProductFromRoom()
        viewModelScope.launch {
            productRepo.getProducts()
        }
    }

    fun getAllReviewFromRoom(){
        //productRepo.getAllProductWithReviewFromRoom()
        viewModelScope.launch {

        }
    }

    fun getAllDimensionsFromRoom(){
        //productRepo.getAllProductWithDimensionFromRoom()
        viewModelScope.launch {

        }
    }
}