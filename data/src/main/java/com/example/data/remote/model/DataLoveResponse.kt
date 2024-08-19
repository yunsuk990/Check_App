package com.example.data.remote.model

import com.google.gson.annotations.SerializedName


data class DataLoveResponse(
    @SerializedName(value = "first name: ") val fname: String,
    @SerializedName(value = "second name: ") val sname: String,
    @SerializedName(value = "percentage match: ")val percentage: Float,
    @SerializedName(value = "result: ") val result: String
)
