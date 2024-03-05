package com.example.gz.player.ui

import com.example.gz.media.domain.Playlist

sealed class ReplyOnAddTrack {
    class Contained(val playlist: Playlist) : ReplyOnAddTrack()
    class Added(val playlist: Playlist) : ReplyOnAddTrack()
}
