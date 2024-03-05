package com.example.gz.servicesGz.domain

class ServicesGzInteractorImpl (private val servicesGzRepository: ServicesGzRepository) : ServicesGzInteractor{
    override suspend fun getServices (position: String): ArrayList<Products> {
        return servicesGzRepository.getServices(position)
    }

}