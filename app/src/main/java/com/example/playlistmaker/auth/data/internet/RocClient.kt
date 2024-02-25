package com.example.playlistmaker.auth.data.internet

import com.example.playlistmaker.auth.data.dto.AuthResponse

interface RocClient {
    suspend fun doRequest(dto: Any): AuthResponse
}