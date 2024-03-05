package com.example.gz.player.domain

import com.example.gz.search.domain.TrackModel

interface MediaPlayerRepository {

    val isPlaying : Boolean

    fun preparePlayer(url: String, onPreparedListener: () -> Unit)

    fun setOnCompletionListener(onCompletionListener: () -> Unit)

    fun currentPosition(): Int

    fun startPlayer()

    fun pausePlayer()

    fun stopPlayer ()

    fun destroyPlayer()

    fun getTrack() : TrackModel

    fun isNightTheme() : Boolean
}