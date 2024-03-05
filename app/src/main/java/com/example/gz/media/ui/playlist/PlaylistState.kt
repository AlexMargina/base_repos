package com.example.gz.media.ui.playlist

import com.example.gz.media.domain.Playlist

sealed class PlaylistState {
    class Playlists(val playlists: List<Playlist>) : PlaylistState()
    object Empty : PlaylistState()
}