package com.example.gz.servicesGz.data

import com.example.gz.auth.data.internet.HttpConnection
import com.example.gz.servicesGz.domain.Json4Kotlin_Base
import com.example.gz.servicesGz.domain.Products
import com.example.gz.servicesGz.domain.ServicesGzRepository
import com.google.gson.Gson
import com.google.gson.JsonParser

class ServicesGzRepositoryImpl(private val httpConnection: HttpConnection): ServicesGzRepository {
    override suspend fun getServices(position: String): ArrayList<Products> {
        var params = ""
        if (position != "Админ") {
            params = "position=%27$position%27"
        }

        val json = httpConnection.getServices(params)

        val prettyJson = Gson().toJson(JsonParser.parseString(json))
        val result = Gson().fromJson(prettyJson, Json4Kotlin_Base::class.java)

        return result.products
    }
    companion object{
        private const val TAG_SUCCESS = "success"
    }
}



