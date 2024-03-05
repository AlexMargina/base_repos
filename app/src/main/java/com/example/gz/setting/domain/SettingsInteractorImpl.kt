package com.example.gz.setting.domain


class SettingsInteractorImpl (private val repository: SettingsRepository) : SettingsInteractor {

    override fun getThemeSettings(): Boolean {
         return repository.getThemeSettings() !!
    }

    override fun switchTheme(darkThemeEnabled: Boolean) {
        repository.switchTheme(darkThemeEnabled)
    }
}