package com.example.gz.auth.data

import android.content.Context
import com.example.gz.auth.data.internet.HttpConnection
import com.example.gz.auth.data.internet.RocClient
import com.example.gz.auth.domain.AuthRepository

class AuthRepositoryImpl(
    private val rocClient: RocClient,
    private val httpConnection: HttpConnection,
    private val context: Context
): AuthRepository {

    override suspend fun checkUser (user: String, pass: String): String {
        val params = "user='$user'&pass='$pass'"
        val userAuthResponce = httpConnection.checkUser(params)
        return userAuthResponce.results
    }
}