package com.example.playlistmaker.auth.data.internet

import com.example.playlistmaker.auth.data.dto.Responce

interface RocClient {
    suspend fun doRequest(dto: Any): Responce
}