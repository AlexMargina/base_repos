package com.example.playlistmaker.auth.domain

interface AuthRepository {
    suspend fun checkUser (user: String, pass: String): String
}