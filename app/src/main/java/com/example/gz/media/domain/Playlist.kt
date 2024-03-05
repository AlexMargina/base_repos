package com.example.gz.media.domain

import com.example.gz.search.domain.TrackModel


data class Playlist(
    val idPl: Int,
    val namePl: String,
    val descriptPl: String = "",
    val imagePl: String = "",
    val tracksPl: ArrayList<TrackModel> = arrayListOf(),
    var countTracks: Int = 0,
    val timePl : Long = 0
)