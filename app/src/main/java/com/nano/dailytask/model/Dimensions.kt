package com.nano.dailytask.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Dimensions(
    val depth: Double,
    val height: Double,
    val width: Double
)