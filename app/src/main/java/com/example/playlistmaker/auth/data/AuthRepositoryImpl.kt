package com.example.playlistmaker.auth.data

import android.content.Context
import android.util.Log
import com.example.playlistmaker.auth.data.dto.UserAuthRequest
import com.example.playlistmaker.auth.data.internet.RocClient
import com.example.playlistmaker.auth.domain.AuthRepository

class AuthRepositoryImpl(
    private val rocClient: RocClient
): AuthRepository {

    override suspend fun checkUser (user: String, pass: String): ArrayList<String> {
        val expression: String = "user=$user&&pass=$pass"
        //val request: UserAuthRequest = UserAuthRequest(expression)
        val response = rocClient.doRequest(expression)

        Log.d ("MAALMI_AuthRepo","checkUser response=${response.resultCode}")

        val result = arrayListOf<String>()
        result.add(0, user)
        result.add(0, response.resultCode.toString())
        return result
    }
}