package com.example.gz.media.domain.favorite

import com.example.gz.search.domain.TrackModel
import kotlinx.coroutines.flow.Flow

interface FavoriteInteractor {
    fun favoriteTracks(): Flow<ArrayList<TrackModel>>
    fun setClickedTrack(track: TrackModel)
}