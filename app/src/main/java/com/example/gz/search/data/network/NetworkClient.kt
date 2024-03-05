package com.example.gz.search.data.network

import com.example.gz.search.data.dto.Response

interface NetworkClient {
    suspend fun doRequest(dto: Any): Response
}