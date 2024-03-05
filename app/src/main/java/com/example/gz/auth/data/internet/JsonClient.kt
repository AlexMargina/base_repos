package com.example.gz.auth.data.internet

import com.example.gz.auth.data.dto.Responce

interface JsonClient {
    suspend fun checkUser(expression : String): Responce
}