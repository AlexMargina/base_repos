package com.example.gz.di

import com.example.gz.auth.data.AuthRepositoryImpl
import com.example.gz.auth.domain.AuthRepository
import com.example.gz.media.data.FavoriteRepositoryImpl
import com.example.gz.media.data.NewPlaylistRepositoryImpl
import com.example.gz.media.data.PlaylistRepositoryImpl
import com.example.gz.media.data.convertor.TrackDbConvertor
import com.example.gz.media.domain.favorite.FavoriteRepository
import com.example.gz.media.domain.newPlaylist.NewPlaylistRepository
import com.example.gz.media.domain.playlist.PlaylistRepository
import com.example.gz.player.data.MediaPlayerRepositoryImpl
import com.example.gz.player.domain.MediaPlayerRepository
import com.example.gz.search.data.SearchDataStorage
import com.example.gz.search.data.SearchRepositoryImpl
import com.example.gz.search.data.SharedPrefsUtils
import com.example.gz.search.domain.SearchRepository
import com.example.gz.servicesGz.data.ServicesGzRepositoryImpl
import com.example.gz.servicesGz.domain.ServicesGzRepository
import com.example.gz.setting.data.SettingsRepositoryImpl
import com.example.gz.setting.domain.SettingsRepository
import com.example.gz.sharing.data.ExternalNavigatorImpl
import com.example.gz.sharing.domain.ExternalNavigator
import org.koin.dsl.module

val repositoryModule = module {

    single<AuthRepository> {
        AuthRepositoryImpl(get(), get(), get())
    }

    single<ServicesGzRepository> {
        ServicesGzRepositoryImpl(get())
    }

    factory<MediaPlayerRepository> {
        MediaPlayerRepositoryImpl(get())
    }

    single<ExternalNavigator> {
        ExternalNavigatorImpl(get())
    }

    single<SettingsRepository> {
        SettingsRepositoryImpl(get())
    }

    single <SearchDataStorage> {
        SharedPrefsUtils(get(), get(), get())
    }

    single<SearchRepository> {
        SearchRepositoryImpl(get(), get(), get(), get())
    }

    factory { TrackDbConvertor() }

    single<FavoriteRepository> {
        FavoriteRepositoryImpl(get(), get())
    }

    single <NewPlaylistRepository> {
        NewPlaylistRepositoryImpl (get())
    }

    single <PlaylistRepository> {
        PlaylistRepositoryImpl (get())
    }
}
