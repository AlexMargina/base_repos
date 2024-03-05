package com.example.gz.servicesGz.domain

interface ServicesGzInteractor {
    suspend fun getServices(position: String): ArrayList<Products>

}