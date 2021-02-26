package com.safa.breakingbad.model

import com.google.gson.annotations.SerializedName

data class Actor(
    @SerializedName("char_id")
    val id: Int,

    val name: String,
    val birthday: String,
    val occupation: List<String>,
    val img: String,
    val status: String,
    val nickname: String,
    val appearance: List<Int>,
    val portrayed: String,
    val category: String,

    @SerializedName("better_call_saul_appearance")
    val betterCallSaulAppearance: List<Int>


)