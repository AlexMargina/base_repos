package com.example.gz.auth.domain

interface AuthRepository {
    suspend fun checkUser (user: String, pass: String): String
}