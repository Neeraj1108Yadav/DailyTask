package com.nano.dailytask.model

/**
 * Created By Neeraj Yadav on 16/09/24
 */
data class CosmeticModel(
    val id: Int,
    val availabilityStatus: String,
    var brand: String? = null,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val images: List<String>,
    val minimumOrderQuantity: Int,
    val price: Double,
    val rating: Double,
    val returnPolicy: String,
    val shippingInformation: String,
    val stock: Int,
    val tags: List<String>,
    val thumbnail: String,
    val title: String,
    val warrantyInformation: String,
    val weight: Int,
    val dimensions:DimensionsTable,
    val reviews:List<ReviewTable>
)
