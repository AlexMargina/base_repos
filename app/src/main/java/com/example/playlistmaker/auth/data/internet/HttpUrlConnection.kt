package com.example.playlistmaker.auth.data.internet

import android.util.Log
import com.example.playlistmaker.auth.data.dto.UserAuthResponce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class HttpUrlConnection {
    val domain = "https://gz.roc76.ru/"
    suspend fun checkUser(user: String, pass: String): UserAuthResponce {
        val result = "null"
        val phpComand = "check_user.php?"
        val params = "user='$user'&pass='$pass'"
        val url = URL("$domain$phpComand$params")
        val httpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.requestMethod = "POST"
        httpURLConnection.setRequestProperty("Content-Type","application/json") // The format of the content we're sending to the server
        httpURLConnection.setRequestProperty("Accept","application/json") // The format of response we want to get from the server
        httpURLConnection.doInput = true
        httpURLConnection.doOutput = true

        Log.d("MAALMI_rawJSON", "jsonObjectString   ${httpURLConnection.url}")

        return withContext(Dispatchers.IO) {
            httpURLConnection.connect()
            val httpCode = httpURLConnection.responseCode

            when (httpCode != 0) {
                true -> {
                    UserAuthResponce().apply {

                        results = httpURLConnection.inputStream.bufferedReader()
                            .use { it.readText() }  // defaults to UTF-8
                    }
                }

                false -> {
                    UserAuthResponce().apply { resultCode = httpURLConnection.responseCode }
                }
            }
        }
    }
}

