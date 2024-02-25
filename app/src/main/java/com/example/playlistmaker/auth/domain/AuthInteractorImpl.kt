package com.example.playlistmaker.auth.domain

import android.util.Log


class AuthInteractorImpl (private val servicesGzRepository: AuthRepository) :
    AuthInteractor {
    override suspend fun checkUser (user: String, pass: String): ArrayList<String> {
        Log.d ("MAALMI_AuthInter","checkUser")
         return servicesGzRepository.checkUser (user, pass)
    }

}