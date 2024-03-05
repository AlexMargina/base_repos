package com.example.gz.setting.domain

interface SettingsInteractor {

    fun getThemeSettings(): Boolean

    fun switchTheme(darkThemeEnabled: Boolean)
}