package com.example.gz.media.ui.favorite


import com.example.gz.search.domain.TrackModel

sealed class FavoriteState {

    object Loading : FavoriteState()

    data class Content(
        val tracks: ArrayList<TrackModel>
    ) : FavoriteState()

    data class Empty(
        val message: String
    ) : FavoriteState()
}