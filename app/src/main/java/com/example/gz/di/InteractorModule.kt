package com.example.gz.di

import com.example.gz.auth.domain.AuthInteractor
import com.example.gz.auth.domain.AuthInteractorImpl
import com.example.gz.klassGz.domain.KlassGzInteractor
import com.example.gz.klassGz.domain.KlassGzInteractorImpl
import com.example.gz.media.domain.favorite.FavoriteInteractor
import com.example.gz.media.domain.favorite.FavoriteInteractorImpl
import com.example.gz.media.domain.newPlaylist.NewPlaylistInteractor
import com.example.gz.media.domain.newPlaylist.NewPlaylistInteractorImpl
import com.example.gz.media.domain.playlist.PlaylistInteractor
import com.example.gz.media.domain.playlist.PlaylistInteractorImpl
import com.example.gz.player.domain.MediaPlayerInteractor
import com.example.gz.player.domain.MediaPlayerInteractorImpl
import com.example.gz.search.domain.SearchInteractor
import com.example.gz.search.domain.SearchInteractorImpl
import com.example.gz.servicesGz.domain.ServicesGzInteractor
import com.example.gz.servicesGz.domain.ServicesGzInteractorImpl
import com.example.gz.setting.domain.SettingsInteractor
import com.example.gz.setting.domain.SettingsInteractorImpl
import com.example.gz.sharing.domain.SharingInteractor
import com.example.gz.sharing.domain.SharingInteractorImpl
import org.koin.dsl.module

val interactorModule = module {

    single<AuthInteractor> { AuthInteractorImpl(get()) }

    single<KlassGzInteractor> { KlassGzInteractorImpl() }

    single<ServicesGzInteractor> { ServicesGzInteractorImpl(get()) }

    factory<MediaPlayerInteractor> {
        MediaPlayerInteractorImpl(get(), get(), get())
    }

    single<SharingInteractor> {
        SharingInteractorImpl(get())
    }

    single<SettingsInteractor> {
        SettingsInteractorImpl(get())
    }

    single<SearchInteractor> {
        SearchInteractorImpl(get())
    }

    single<FavoriteInteractor> {
        FavoriteInteractorImpl(get())
    }

    single<PlaylistInteractor> {
        PlaylistInteractorImpl(get())
    }

    single<NewPlaylistInteractor> {
        NewPlaylistInteractorImpl(get())
    }

}