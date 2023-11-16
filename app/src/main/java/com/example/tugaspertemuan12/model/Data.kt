package com.example.tugaspertemuan12.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("name")
    val name:String,
    @SerializedName("species")
    val species:String,
    @SerializedName("gender")
    val gender:String,
    @SerializedName("location")
    val location:String,
    @SerializedName("image")
    val image:String,
)

