package com.example.gz.search.data

import com.example.gz.search.data.dto.TrackDto

interface SearchDataStorage {
    suspend fun getSearchHistory(): ArrayList<TrackDto>
    suspend fun clearHistory()
    suspend fun addTClickedSearchSongs(track: TrackDto)

}