package com.example.gz.di

import com.example.gz.auth.ui.AuthViewModel
import com.example.gz.klassGz.ui.KlassGzViewModel
import com.example.gz.main.ui.MainViewModel
import com.example.gz.media.domain.playlist.PlaylistInteractor
import com.example.gz.media.ui.displayPlaylist.DisplayPlaylistViewModel
import com.example.gz.media.ui.favorite.FavoriteViewModel
import com.example.gz.media.ui.newPlaylist.NewPlaylistViewModel
import com.example.gz.media.ui.playlist.PlaylistViewModel
import com.example.gz.media.ui.updatePlaylist.UpdatePlaylistViewModel
import com.example.gz.player.domain.MediaPlayerInteractor
import com.example.gz.player.ui.PlayerViewModel
import com.example.gz.search.ui.SearchViewModel
import com.example.gz.servicesGz.ui.ServicesGzViewModel
import com.example.gz.setting.ui.SettingViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
       AuthViewModel (get(), get())
    }

    viewModel {
        ServicesGzViewModel (get(), get())
    }

    viewModel {
        KlassGzViewModel (get())
    }

    viewModel {
        MainViewModel ()
    }

    viewModel {
        PlayerViewModel(
            get<MediaPlayerInteractor>(),
            get<PlaylistInteractor>()
        )
    }

    viewModel {
        SettingViewModel(
            get(),
            get()
        )
    }

    viewModel {
        SearchViewModel(
           get()
        )
    }

    viewModel {
        FavoriteViewModel(androidContext(), get())
    }

    viewModel {
        NewPlaylistViewModel(get(), get())
    }

    viewModel {
        PlaylistViewModel(get())
    }


    viewModel {
        DisplayPlaylistViewModel(get(), get(), get(), get())
    }

    viewModel {
        UpdatePlaylistViewModel(get(), get())
    }

}