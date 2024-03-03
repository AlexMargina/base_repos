package com.example.playlistmaker.auth.data.internet

import android.content.Context
import android.util.Log
import com.example.playlistmaker.auth.data.dto.Responce
import com.example.playlistmaker.auth.data.dto.UserAuthRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class RetrofitRocClient(
    private val rocService: RocApi,
    private val context: Context
) : RocClient {

    override suspend fun doRequest(dto: Any): Responce {
        if (! IsOnline().isOnline(context)) {
            return Responce().apply { resultCode = - 1 }
        }
        Log.d("MAALMI_Retrofit", "dto (${dto.toString()})")
        return if (dto is UserAuthRequest) {
            withContext(Dispatchers.IO) {
                try {
                    val response = rocService.search(dto.expression)
                    response.apply { resultCode = 200 }
                } catch (e: Throwable) {
                    Responce().apply { resultCode = 500 }
                }
            }
        } else {
            Responce().apply { resultCode = 400 }
        }
    }
}