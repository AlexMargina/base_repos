package com.example.gz.search.ui

import com.example.gz.search.domain.TrackModel

fun interface TrackClickListener {
    fun onTrackClick(track: TrackModel)
}