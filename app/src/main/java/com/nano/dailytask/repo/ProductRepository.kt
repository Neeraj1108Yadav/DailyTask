package com.nano.dailytask.repo

import com.nano.dailytask.di.QualifierLocalRepo
import com.nano.dailytask.di.QualifierNetworkRepo
import com.nano.dailytask.listener.FetchProductListener
import com.nano.dailytask.model.Product
import javax.inject.Inject

/**
 * Created By Neeraj Yadav on 23/09/24
 */
class ProductRepository @Inject constructor(
    @QualifierLocalRepo private val localProduct: FetchProductListener,
    @QualifierNetworkRepo private val networkProduct: FetchProductListener
) : FetchProductListener{

    override suspend fun getProducts(): List<Product> {
        return listOf()
    }


    override suspend fun getProductById(id: Int): List<Product> {
        return listOf()
    }

}