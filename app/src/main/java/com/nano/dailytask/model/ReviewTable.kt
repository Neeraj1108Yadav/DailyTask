package com.nano.dailytask.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("productId")
        )
    ]
)
data class ReviewTable(
    @PrimaryKey(autoGenerate = true)
    val reviewId:Int=0,
    val productId:Int,
    val comment: String,
    val date: String,
    val rating: Int,
    val reviewerEmail: String,
    val reviewerName: String
)