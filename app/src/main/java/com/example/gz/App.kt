package com.example.gz

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.gz.di.dataModule
import com.example.gz.di.interactorModule
import com.example.gz.di.repositoryModule
import com.example.gz.di.viewModelModule
import com.example.gz.sharing.data.AppPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


const val MUSIC_MAKER_PREFERENCES = "music_maker_preferences"
const val CLICKED_SEARCH_TRACK = "clicked_search_track"
const val DARK_THEME_ENABLED = "DARK_THEME_ENABLED"


class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App as Application)
            modules(dataModule, repositoryModule, interactorModule, viewModelModule)
        }

        AppPreferences.setup(applicationContext)
        if (AppPreferences.darkTheme != null) {
            darkTheme = AppPreferences.darkTheme !!
            switchTheme(darkTheme)
        }
    }

    fun switchTheme(darkThemeEnabled: Boolean) {

        AppCompatDelegate.setDefaultNightMode(
            if (darkThemeEnabled) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_NO
            }
        )
    }

    companion object {
        var darkTheme = false
    }
}