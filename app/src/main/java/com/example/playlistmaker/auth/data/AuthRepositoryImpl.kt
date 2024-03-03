package com.example.playlistmaker.auth.data

import android.content.Context
import com.example.playlistmaker.auth.data.internet.HttpConnection
import com.example.playlistmaker.auth.data.internet.RocClient
import com.example.playlistmaker.auth.domain.AuthRepository

class AuthRepositoryImpl(
    private val rocClient: RocClient,
    private val httpConnection: HttpConnection,
    private val context: Context
): AuthRepository {

    override suspend fun checkUser (user: String, pass: String): ArrayList<String> {
        val result = arrayListOf<String>()

        val params = "user='$user'&pass='$pass'"
        val userAuthResponce = httpConnection.checkUser(params)
        result.add(0, userAuthResponce.results)
        return result
    }
}