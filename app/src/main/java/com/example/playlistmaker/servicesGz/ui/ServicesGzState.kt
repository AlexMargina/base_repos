package com.example.playlistmaker.servicesGz.ui


sealed class ServicesGzState {

    object Loading : ServicesGzState()

    data class Content(
        val services: ArrayList<String>
    ) : ServicesGzState()

    data class Empty(
        val message: String
    ) : ServicesGzState()
}