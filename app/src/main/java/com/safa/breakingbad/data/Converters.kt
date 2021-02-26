package com.safa.breakingbad.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.w3c.dom.Comment
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList


class Converters {
    @TypeConverter
    fun fromString(value: String?): ArrayList<String> {
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(value, listType)
    }



    @TypeConverter
    fun fromArrayList(list: ArrayList<String?>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }


    @TypeConverter
    fun fromInt(value: Int?): ArrayList<Int> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<Int>>() {}.type
        return gson.fromJson(value.toString(), type)
    }

}