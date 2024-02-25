package com.example.playlistmaker.servicesGz.domain

interface ServicesGzRepository {
    fun checkUser (user: String, pass: String): ArrayList<String>
}