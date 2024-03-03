package com.example.playlistmaker.auth.ui



sealed class AuthState {

    object Loading : AuthState()

    data class Content(
        val services: String
    ) : AuthState()

    data class Empty(
        val message: String
    ) : AuthState()
}