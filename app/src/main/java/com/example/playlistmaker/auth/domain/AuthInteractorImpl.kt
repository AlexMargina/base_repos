package com.example.playlistmaker.auth.domain


class AuthInteractorImpl (private val servicesGzRepository: AuthRepository) :
    AuthInteractor {
    override fun checkUser (user: String, pass: String): ArrayList<String> {
        return servicesGzRepository.checkUser (user, pass)
    }

}