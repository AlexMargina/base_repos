package com.example.playlistmaker.auth.data.internet

import com.example.playlistmaker.auth.data.dto.AuthResponse

interface JsonClient {
    suspend fun checkUser(expression : String): AuthResponse
}