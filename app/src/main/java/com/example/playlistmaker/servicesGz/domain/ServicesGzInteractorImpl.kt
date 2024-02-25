package com.example.playlistmaker.servicesGz.domain

class ServicesGzInteractorImpl (private val servicesGzRepository: ServicesGzRepository) : ServicesGzInteractor{
    override fun checkUser (user: String, pass: String): ArrayList<String> {
        return servicesGzRepository.checkUser (user, pass)
    }

}