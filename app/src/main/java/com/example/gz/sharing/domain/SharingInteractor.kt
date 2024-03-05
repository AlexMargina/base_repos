package com.example.gz.sharing.domain

interface SharingInteractor {

    fun shareApp()
    fun shareText(sharedText : String, sharedTitle : String)
    fun openSupport()
    fun openTerms()
}