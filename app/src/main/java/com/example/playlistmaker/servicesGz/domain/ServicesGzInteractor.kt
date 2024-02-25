package com.example.playlistmaker.servicesGz.domain

interface ServicesGzInteractor {
    fun checkUser(user: String, pass: String): ArrayList<String>

}