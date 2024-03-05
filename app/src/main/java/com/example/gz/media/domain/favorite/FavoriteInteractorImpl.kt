package com.example.gz.media.domain.favorite

import com.example.gz.search.domain.TrackModel
import kotlinx.coroutines.flow.Flow

class FavoriteInteractorImpl (private val favoriteRepository: FavoriteRepository):
    FavoriteInteractor {
    override fun favoriteTracks(): Flow<ArrayList<TrackModel>> {

        return favoriteRepository.favoriteTracks()
    }

    override fun setClickedTrack(track: TrackModel) {
        favoriteRepository.setClickedTrack(track)
    }
}