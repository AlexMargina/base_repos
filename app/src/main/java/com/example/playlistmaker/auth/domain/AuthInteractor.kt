package com.example.playlistmaker.auth.domain

import com.example.playlistmaker.search.domain.TrackModel
import kotlinx.coroutines.flow.Flow

interface AuthInteractor {
    fun checkUser(user: String, pass: String): ArrayList<String>

}