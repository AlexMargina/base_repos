package com.example.playlistmaker.auth.domain

interface AuthRepository {
    fun checkUser (user: String, pass: String): ArrayList<String>
}