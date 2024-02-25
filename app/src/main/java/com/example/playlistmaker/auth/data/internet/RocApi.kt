package com.example.playlistmaker.auth.data.internet

import com.example.playlistmaker.auth.data.dto.UserAuthResponce
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RocApi {
    @GET("/search?entity=song")
    suspend fun search(@Query("term") text: String): UserAuthResponce

    @POST ("check_user.php?")
    suspend fun checkUser(@Query("?") expression :String): UserAuthResponce
}