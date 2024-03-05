package com.example.gz.servicesGz.ui

import com.example.gz.servicesGz.domain.Products


sealed class ServicesGzState {

    object Loading : ServicesGzState()

    data class Content(
        val services: ArrayList<Products>
    ) : ServicesGzState()

    data class Empty(
        val message: String
    ) : ServicesGzState()
}