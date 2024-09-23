package com.nano.dailytask.repo

import com.nano.dailytask.db.ProductDao
import com.nano.dailytask.listener.InsertProductListener
import com.nano.dailytask.model.CosmeticProducts
import com.nano.dailytask.model.DimensionsTable
import com.nano.dailytask.model.Product
import com.nano.dailytask.model.ReviewTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created By Neeraj Yadav on 23/09/24
 */
class InsertProductRepository @Inject constructor(
    private val productDao: ProductDao
) : InsertProductListener{

    override suspend fun insertProducts(products: List<Product>) {
        productDao.insertProducts(products)
    }

    override suspend fun insertDimensions(dimension: List<DimensionsTable>) {
        productDao.insertDimensions(dimension)
    }

    override suspend fun insertReviews(reviews: List<ReviewTable>) {
        productDao.insertReviews(reviews)
    }

    override suspend fun getProductFromCosmetic(cosmeticProducts: CosmeticProducts): Product {
        return Product(
            id = cosmeticProducts.id,
            availabilityStatus = cosmeticProducts.availabilityStatus,
            brand = cosmeticProducts.brand,
            category = cosmeticProducts.category,
            description = cosmeticProducts.description,
            discountPercentage = cosmeticProducts.discountPercentage,
            images = cosmeticProducts.images,
            minimumOrderQuantity = cosmeticProducts.minimumOrderQuantity,
            price = cosmeticProducts.price,
            rating = cosmeticProducts.rating,
            shippingInformation = cosmeticProducts.shippingInformation,
            returnPolicy = cosmeticProducts.returnPolicy,
            stock = cosmeticProducts.stock,
            tags = cosmeticProducts.tags,
            thumbnail = cosmeticProducts.thumbnail,
            title = cosmeticProducts.title,
            warrantyInformation = cosmeticProducts.warrantyInformation,
            weight = cosmeticProducts.weight
        )
    }

    override suspend fun getReviewsFromCosmetic(cosmeticProducts: CosmeticProducts): List<ReviewTable> {
        val reviewList = arrayListOf<ReviewTable>()
        cosmeticProducts.reviews.forEach {
            val review = ReviewTable(
                productId = cosmeticProducts.id,
                comment = it.comment,
                rating = it.rating,
                reviewerEmail = it.reviewerEmail,
                reviewerName = it.reviewerName,
                date = it.date
            )
            reviewList.add(review)
        }
        return reviewList
    }

    override suspend fun getDimensionFromCosmetic(cosmeticProducts: CosmeticProducts): DimensionsTable {
        return DimensionsTable(
            productId = cosmeticProducts.id.toString(),
            depth = cosmeticProducts.dimensions.depth,
            height = cosmeticProducts.dimensions.height,
            width = cosmeticProducts.dimensions.width
        )
    }


}