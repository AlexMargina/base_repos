package com.example.playlistmaker.servicesGz.data

import android.content.Context
import com.example.playlistmaker.servicesGz.domain.ServicesGzRepository

class ServicesGzRepositoryImpl(context: Context): ServicesGzRepository {
    override fun checkUser (user: String, pass: String): ArrayList<String> {
        val result = arrayListOf<String>()
        result.add(0, user)
        result.add(0, pass)
        return result
    }
}