package com.example.playlistmaker.auth.domain

import kotlinx.coroutines.flow.Flow

class AuthInteractorImpl : AuthInteractor{
    override fun checkUser(): ArrayList<String> {
//        TODO("Not yet implemented")
        val result = arrayListOf<String>()
        result.add(0, "LAR")
        result.add(1, "figaro")
        return result
    }

}