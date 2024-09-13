package com.nano.dailytask.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey
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
    val weight: Int
)