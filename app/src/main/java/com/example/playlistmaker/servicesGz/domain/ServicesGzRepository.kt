package com.example.playlistmaker.servicesGz.domain

interface ServicesGzRepository {
    suspend fun getServices(position: String): ArrayList<String>
}