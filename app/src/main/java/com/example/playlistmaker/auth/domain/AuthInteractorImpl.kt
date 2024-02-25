package com.example.playlistmaker.auth.domain

import com.example.playlistmaker.auth.data.AuthRepositoryImpl
import kotlinx.coroutines.flow.Flow

class AuthInteractorImpl (private val authRepository: AuthRepository) : AuthInteractor{
    override fun checkUser (user: String, pass: String): ArrayList<String> {
        return authRepository.checkUser (user, pass)
    }

}