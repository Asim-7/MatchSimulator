package com.miniclip.matchsimulator.utils

import androidx.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class HeadToHeadConverter {
    @TypeConverter
    fun fromMap(value: Map<String, Int?>?): String = Gson().toJson(value)

    @TypeConverter
    fun toMap(value: String): Map<String, Int?> =
        Gson().fromJson(value, object : TypeToken<Map<String, Int?>>() {}.type)
}