package com.nano.dailytask.db

import androidx.room.TypeConverter

/**
 * Created By Neeraj Yadav on 13/09/24
 */
class Converter {

    @TypeConverter
    fun fromString(value:String?):List<String>?{
        return value?.let {
            it.split(",").map { it.trim() }
        }
    }

    @TypeConverter
    fun fromList(list:List<String>?) : String?{
        return list?.joinToString(",")
    }
}