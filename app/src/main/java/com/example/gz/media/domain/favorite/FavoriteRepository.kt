package com.example.gz.media.domain.favorite

import com.example.gz.search.domain.TrackModel
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    fun favoriteTracks(): Flow<ArrayList<TrackModel>>

    suspend fun deleteDbTrack (trackId :String)

    fun setClickedTrack(track: TrackModel)

    suspend fun insertDbTrackToFavorite (track: TrackModel)

    suspend fun deleteDbTrackFromFavorite(trackId: String)
}