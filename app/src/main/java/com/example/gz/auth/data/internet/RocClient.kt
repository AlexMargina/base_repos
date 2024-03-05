package com.example.gz.auth.data.internet

import com.example.gz.auth.data.dto.Responce

interface RocClient {
    suspend fun doRequest(dto: Any): Responce
}