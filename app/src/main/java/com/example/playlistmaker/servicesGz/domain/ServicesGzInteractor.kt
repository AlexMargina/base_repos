package com.example.playlistmaker.servicesGz.domain

interface ServicesGzInteractor {
    suspend fun getServices(position: String): ArrayList<String>

}