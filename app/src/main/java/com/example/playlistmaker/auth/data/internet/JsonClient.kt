package com.example.playlistmaker.auth.data.internet

import com.example.playlistmaker.auth.data.dto.Responce

interface JsonClient {
    suspend fun checkUser(expression : String): Responce
}