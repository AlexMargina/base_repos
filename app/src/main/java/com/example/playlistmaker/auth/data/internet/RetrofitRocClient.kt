package com.example.playlistmaker.auth.data.internet

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
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

        if (! isOnline(context)) {
            return Responce().apply { resultCode = - 1 }
        }
        Log.d("MAALMI_Retrofit", "dto (${dto.toString()})")
        if (dto is UserAuthRequest) {
            return withContext(Dispatchers.IO) {
                try {
                    val response = rocService.search(dto.expression)
                    response.apply { resultCode = 200 }
                } catch (e: Throwable) {
                    Responce().apply { resultCode = 500 }
                }
            }
        } else {
            return Responce().apply { resultCode = 400 }
        }
    }

    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Log.i("MAALMI", "NetworkCapabilities.TRANSPORT_CELLULAR")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Log.i("MAALMI", "NetworkCapabilities.TRANSPORT_WIFI")
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                Log.i("MAALMI", "NetworkCapabilities.TRANSPORT_ETHERNET")
                return true
            }
        }
        return false
    }
}