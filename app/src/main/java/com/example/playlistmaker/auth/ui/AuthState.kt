package com.example.playlistmaker.auth.ui


import com.example.playlistmaker.search.domain.TrackModel

sealed class AuthState {

    object Loading : AuthState()

    data class Content(
        val services: ArrayList<String>
    ) : AuthState()

    data class Empty(
        val message: String
    ) : AuthState()
}