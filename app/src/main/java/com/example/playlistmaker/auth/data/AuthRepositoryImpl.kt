package com.example.playlistmaker.auth.data

import android.content.Context
import com.example.playlistmaker.auth.domain.AuthRepository

class AuthRepositoryImpl(context: Context): AuthRepository{
    override fun checkUser (user: String, pass: String): ArrayList<String> {
        val result = arrayListOf<String>()
        result.add(0, user)
        result.add(1, pass)
        return result
    }
}