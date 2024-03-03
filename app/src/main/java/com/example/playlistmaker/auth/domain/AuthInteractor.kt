package com.example.playlistmaker.auth.domain


interface AuthInteractor {
    suspend  fun checkUser(user: String, pass: String): String

}