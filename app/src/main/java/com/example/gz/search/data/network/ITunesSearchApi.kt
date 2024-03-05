package com.example.gz.search.data.network

import com.example.gz.search.data.dto.TracksSearchResponse
import retrofit2.http.*


interface ITunesSearchApi {
    @GET("/search?entity=song")
    suspend fun search(@Query("term") text: String): TracksSearchResponse
}
