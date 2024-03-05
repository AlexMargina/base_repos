package com.example.gz.servicesGz.domain

interface ServicesGzRepository {
    suspend fun getServices(position: String): ArrayList<Products>
}