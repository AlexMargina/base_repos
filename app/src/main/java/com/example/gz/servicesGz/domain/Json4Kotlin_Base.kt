package com.example.gz.servicesGz.domain

import com.google.gson.annotations.SerializedName

data class Json4Kotlin_Base(
    @SerializedName("products") val products : ArrayList<Products>,
    @SerializedName("success") val success : Int
)
