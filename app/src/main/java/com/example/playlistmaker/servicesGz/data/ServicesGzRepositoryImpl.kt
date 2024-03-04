package com.example.playlistmaker.servicesGz.data

import android.util.Log
import com.example.playlistmaker.auth.data.internet.HttpConnection
import com.example.playlistmaker.servicesGz.domain.ServicesGzRepository
import com.google.gson.Gson
import com.google.gson.JsonParser

class ServicesGzRepositoryImpl(private val httpConnection: HttpConnection): ServicesGzRepository {
    override suspend fun getServices(position: String): ArrayList<String> {
        var params = ""
        if (position != "Админ") {
             params = "position=%27$position%27"
        }

        val json = httpConnection.getServices(params)
        val gson = Gson()


        val prettyJson = gson.toJson(JsonParser.parseString(json))
        Log.d("MAALMI_Pretty Printed JSON :", prettyJson)

        val result = arrayListOf<String>()
        result.add(prettyJson)

//        val type: Type = object : TypeToken<ArrayList<Services?>?>() {}.type
//        val readResult = gson.fromJson<Any>(json, type) as ArrayList<Services>
//        val result = readResult.map {
//            java.lang.String(
//                it.Usluga
//            )
//        }

        return result as ArrayList<String>
    }
}

