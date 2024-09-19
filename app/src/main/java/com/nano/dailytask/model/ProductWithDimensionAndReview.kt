package com.nano.dailytask.model

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Created By Neeraj Yadav on 16/09/24
 */
data class ProductWithDimensionAndReview(
    @Embedded
    val product: Product,
    @Relation(
        parentColumn = "id",
        entityColumn = "productId"
    )
    val reviewTable:List<ReviewTable>,
    @Relation(
        parentColumn = "id",
        entityColumn = "productId"
    )
    val dimensions: List<DimensionsTable>
)