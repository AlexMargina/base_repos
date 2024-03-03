package com.example.playlistmaker.servicesGz.domain

class ServicesGzInteractorImpl (private val servicesGzRepository: ServicesGzRepository) : ServicesGzInteractor{
    override suspend fun getServices (position: String): ArrayList<String> {
        return servicesGzRepository.getServices(position)
    }

}