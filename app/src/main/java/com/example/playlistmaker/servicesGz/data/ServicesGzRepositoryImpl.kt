package com.example.playlistmaker.servicesGz.data

import com.example.playlistmaker.auth.data.internet.HttpConnection
import com.example.playlistmaker.servicesGz.domain.ServicesGzRepository

class ServicesGzRepositoryImpl(private val httpConnection: HttpConnection): ServicesGzRepository {
    override suspend fun getServices(position: String): ArrayList<String> {
        val params = "position='$position'"
        val userAuthResponce = httpConnection.getServices(params)
        return userAuthResponce

        val result = arrayListOf<String>()
        result.add(0, "LFK")
        result.add(0, "massaj")
        result.add(0, "psiholof")
        return result
    }
}