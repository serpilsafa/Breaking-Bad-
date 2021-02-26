package com.safa.breakingbad.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.safa.breakingbad.data.Converters

@Entity(tableName = "breakingbad")
data class Actor(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("char_id")
    val id: Int,

    val name: String,
    val birthday: String,

    val occupation: ArrayList<String>,
    val img: String,
    val status: String,
    val nickname: String,

    @Expose
    val appearance: ArrayList<String>,
    val portrayed: String,
    val category: String,

    @Expose
    @SerializedName("better_call_saul_appearance")
    val betterCallSaulAppearance: ArrayList<String>
)