package com.example.gz.media.ui.favorite

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gz.media.domain.favorite.FavoriteInteractor
import com.example.gz.search.domain.TrackModel
import com.example.playlistmaker.R
import kotlinx.coroutines.launch


class FavoriteViewModel(
    private val context: Context,
    private val favoriteInteractor: FavoriteInteractor
) : ViewModel() {

    private val _stateLiveData = MutableLiveData<FavoriteState>()
    val stateLiveData: LiveData<FavoriteState> = _stateLiveData

    init {
        fillData()
        Log.d("MAALMI_FavoriteViewModel", "init}")
    }

    fun fillData() {
        renderState(FavoriteState.Loading)
        viewModelScope.launch {
            favoriteInteractor
                .favoriteTracks()
                .collect { tracks ->
                    processResult(tracks)
                }
        }
    }

    private fun processResult(tracks: ArrayList<TrackModel>) {
        if (tracks.isEmpty()) {
            renderState(FavoriteState.Empty(context.getString(R.string.empty_favorites)))
        } else {
            renderState(FavoriteState.Content(tracks))
        }
    }

    private fun renderState(state: FavoriteState) {
        _stateLiveData.postValue(state)
    }

    fun setClickedTrack(track: TrackModel, favoriteFragment: FavoriteFragment) {
        favoriteInteractor.setClickedTrack(track)
    }
}