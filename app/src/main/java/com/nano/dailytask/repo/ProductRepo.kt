package com.nano.dailytask.repo

import Fashion
import android.util.Log
import com.nano.dailytask.api.ApiService
import com.nano.dailytask.db.ProductDao
import com.nano.dailytask.model.CosmeticModel
import com.nano.dailytask.model.DimensionsTable
import com.nano.dailytask.model.Product
import com.nano.dailytask.model.ReviewTable
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created By Neeraj Yadav on 13/09/24
 */
class ProductRepo @Inject constructor(private val productDao: ProductDao,
                                      private val apiService: ApiService) {

    fun getAllProduct(){
       val productCall = apiService.getProducts()
       productCall.enqueue(object : Callback<Fashion> {
           override fun onResponse(call: Call<Fashion>, response: Response<Fashion>) {
              if(response.isSuccessful){
                  response.body()?.products?.forEach {
                      Log.d("daily","Product : $it")
                      insertProduct(it)
                      insertDimensions(it)
                      insertReviews(it)
                  }
              }
           }

           override fun onFailure(call: Call<Fashion>, t: Throwable) {
               Log.d("daily","Product : ${t.toString()}")
           }
       })
    }

    private fun insertProduct(cosmeticModel:CosmeticModel){
        val product = Product(
            id = cosmeticModel.id,
            availabilityStatus = cosmeticModel.availabilityStatus,
            brand = cosmeticModel.brand,
            category = cosmeticModel.category,
            description = cosmeticModel.description,
            discountPercentage = cosmeticModel.discountPercentage,
            images = cosmeticModel.images,
            minimumOrderQuantity = cosmeticModel.minimumOrderQuantity,
            price = cosmeticModel.price,
            rating = cosmeticModel.rating,
            shippingInformation = cosmeticModel.shippingInformation,
            returnPolicy = cosmeticModel.returnPolicy,
            stock = cosmeticModel.stock,
            tags = cosmeticModel.tags,
            thumbnail = cosmeticModel.thumbnail,
            title = cosmeticModel.title,
            warrantyInformation = cosmeticModel.warrantyInformation,
            weight = cosmeticModel.weight
        )

        productDao.insertProducts(product)
    }

    private fun insertDimensions(cosmeticModel:CosmeticModel){
        val dimension = DimensionsTable(
            productId = cosmeticModel.id.toString(),
            depth = cosmeticModel.dimensions.depth,
            height = cosmeticModel.dimensions.height,
            width = cosmeticModel.dimensions.width
        )

        productDao.insertDimensions(dimension)
    }

    private fun insertReviews(cosmeticModel:CosmeticModel){

        cosmeticModel.reviews.forEach {
            val review = ReviewTable(
                productId = cosmeticModel.id,
                comment = it.comment,
                rating = it.rating,
                reviewerEmail = it.reviewerEmail,
                reviewerName = it.reviewerName,
                date = it.date
            )

            productDao.insertReviews(review)
        }
    }

    fun getAllProductFromRoom(){
        val products = productDao.getAllProducts()
        Log.d("daily","Product : ${products.toString()}")
    }

    fun getAllProductWithReviewFromRoom(){
        val products = productDao.getAllProductWithReviews()
        Log.d("daily","Review : ${JSONArray(products)}")
    }

    fun getAllProductWithDimensionFromRoom(){
        val products = productDao.getAllProductWithDimension()
        Log.d("daily","Dimension : ${JSONArray(products)}")
    }
}