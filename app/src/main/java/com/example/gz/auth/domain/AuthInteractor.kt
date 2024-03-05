package com.example.gz.auth.domain


interface AuthInteractor {
    suspend  fun checkUser(user: String, pass: String): String

}