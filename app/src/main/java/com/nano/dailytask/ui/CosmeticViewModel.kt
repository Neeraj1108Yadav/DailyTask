package com.nano.dailytask.ui

import androidx.lifecycle.ViewModel
import com.nano.dailytask.repo.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created By Neeraj Yadav on 13/09/24
 */
@HiltViewModel
class CosmeticViewModel @Inject constructor(private val productRepo:ProductRepo) : ViewModel(){

    fun getAllProducts(){
        productRepo.getAllProduct()
    }
}