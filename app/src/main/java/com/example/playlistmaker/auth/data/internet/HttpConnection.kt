package com.example.playlistmaker.auth.data.internet

import com.example.playlistmaker.auth.data.dto.UserAuthResponce

interface HttpConnection  {
    suspend fun checkUser(params : String): UserAuthResponce

    suspend fun getServices(position: String): ArrayList<String>
}