package com.example.gz.auth.data.internet

import com.example.gz.auth.data.dto.UserAuthResponce

interface HttpConnection  {
    suspend fun checkUser(params : String): UserAuthResponce

    suspend fun getServices(position: String): String
}