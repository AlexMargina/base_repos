package com.example.playlistmaker.auth.data.internet

import android.content.Context
import com.example.playlistmaker.auth.data.dto.UserAuthResponce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class HttpUrlConnection (val context: Context): HttpConnection {
    val domain = "https://gz.roc76.ru/"

    override suspend fun checkUser(params: String): UserAuthResponce {
        val phpComand = "check_user.php?"
        val url = URL("$domain$phpComand$params")
        val httpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.requestMethod = "POST"
        httpURLConnection.setRequestProperty(
            "Content-Type",
            "application/json"
        ) // The format of the content we're sending to the server
        httpURLConnection.setRequestProperty(
            "Accept",
            "application/json"
        ) // The format of response we want to get from the server
        httpURLConnection.doInput = true
        httpURLConnection.doOutput = true

        if (! IsOnline().isOnline(context)) {
            return UserAuthResponce().apply { resultCode = - 1 }
        }

        return withContext(Dispatchers.IO) {
            httpURLConnection.connect()
            val httpCode = httpURLConnection.responseCode

            when (httpCode == 200) {
                true -> {
                    UserAuthResponce().apply {
                        results = httpURLConnection.inputStream.bufferedReader()
                            .use { it.readText() }  // defaults to UTF-8
                    }
                }

                false -> {
                    UserAuthResponce().apply { resultCode = httpCode }
                }
            }
        }
    }

    override suspend fun getServices(params: String): ArrayList<String> {
        var result  = arrayListOf<String>()
        val phpComand = "check_user.php?"
        val url = URL("$domain$phpComand$params")
        val httpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.requestMethod = "GET"
        httpURLConnection.setRequestProperty(
            "Content-Type",
            "application/json"
        ) // The format of the content we're sending to the server
        httpURLConnection.setRequestProperty(
            "Accept",
            "application/json"
        ) // The format of response we want to get from the server
        httpURLConnection.doInput = true
        httpURLConnection.doOutput = true

        if (! IsOnline().isOnline(context)) {
            return result
        }

         withContext(Dispatchers.IO) {
            httpURLConnection.connect()
            val httpCode = httpURLConnection.responseCode

            if (httpCode == 200) {

                    httpURLConnection.inputStream.bufferedReader().lines().forEach { line -> result.add (line) }
                    return@withContext result

                } else {
                return@withContext result
            }
         }
        return result
    }
}

