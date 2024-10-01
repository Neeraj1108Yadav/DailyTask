package com.nano.dailytask.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("productId"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class DimensionsTable(
    @PrimaryKey(autoGenerate = true)
    val dimensionId:Int = 0,
    val depth: Double,
    val height: Double,
    val width: Double,
    val productId:String
)