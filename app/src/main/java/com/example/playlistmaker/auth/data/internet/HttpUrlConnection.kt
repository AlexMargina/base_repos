package com.example.playlistmaker.auth.data.internet

import android.content.Context
import android.util.Log
import com.example.playlistmaker.auth.data.dto.UserAuthResponce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
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

    override suspend fun getServices(params: String): String {
        var result  = ""
        val phpComand = "get_all_usluga.php?"
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
        Log.d("MAALMI_HttpUrlConnection_1", "getServices: url: $url")
        if (! IsOnline().isOnline(context)) {
            return result
        }

        return withContext(Dispatchers.IO) {
            httpURLConnection.connect()
            val httpCode = httpURLConnection.responseCode
            Log.d("MAALMI_HttpUrlConnection_2", "getServices: httpCode: $httpCode")
            Log.d("MAALMI_HttpUrlConnection_3", "getServices: Message: ${httpURLConnection.responseMessage}")
            if (httpCode == 200) {

                var reader = BufferedReader(InputStreamReader(httpURLConnection.inputStream))
                var strBuilder = StringBuilder()
                reader.forEachLine {
                    strBuilder.append(it)
                    result = it
                    Log.e("MAALMI_HttpUrlConnection_7", it)
                }



                Log.d("MAALMI_HttpUrlConnection_4", "getServices: result: $result")
                    //httpURLConnection.inputStream.bufferedReader().lines().forEach { line -> result.add (line) }
                Log.d("MAALMI_HttpUrlConnection_5", "getServices: result: $result")
                    return@withContext result

                } else {
                Log.d("MAALMI_HttpUrlConnection_6", "getServices: result: $result")
                return@withContext result
            }
         }

    }
}

