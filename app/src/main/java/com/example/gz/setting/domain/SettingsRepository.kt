package com.example.gz.setting.domain

interface SettingsRepository  {

    fun getThemeSettings(): Boolean?

    fun switchTheme(darkThemeEnabled: Boolean)
}