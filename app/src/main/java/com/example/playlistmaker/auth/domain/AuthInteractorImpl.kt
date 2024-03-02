package com.example.playlistmaker.auth.domain

import android.util.Log


class AuthInteractorImpl (private val authRepository: AuthRepository) :
    AuthInteractor {
    override suspend fun checkUser (user: String, pass: String): ArrayList<String> {
        Log.d ("MAALMI_AuthInter","checkUser")
         return authRepository.checkUser (user, pass)
    }

}