package com.example.playlistmaker.auth.data.internet

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import com.example.playlistmaker.auth.data.dto.AuthResponse
import com.example.playlistmaker.auth.data.dto.UserAuthRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

class JsonRocClient (val context: Context) : JsonClient {

    override suspend fun checkUser(expression: String): AuthResponse {

        val url_check_user = "https://roc76.ru/check_user.php?$expression"

        val client = OkHttpClient()

        val request = Request.Builder()
            .url(url_check_user)
            .build()
        Log.d ("Maalmi_Json","checkUser: url_check_user: ${url_check_user}")
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.use {
                    if (!response.isSuccessful) {
                        throw IOException("Запрос к серверу не был успешен:" +
                                " ${response.code()} ${response.message()}")
                        Log.d ("Maalmi_Json","checkUser: Запрос к серверу не был успешен:" +
                        " ${response.code()} ${response.message()}")
                    }
                    val headers1 = response.headers().toMultimap()
                    // пример получения всех заголовков ответа
                    for ((name, value) in headers1) {
                        Log.d ("Maalmi_Json","checkUser: Server: ${response.header("Server")}")
                        println("$name: $value")
                    }
                    // вывод тела ответа
                    Log.d ("Maalmi_Json","checkUser: response: ${response.body()!!.string()}")
                    println(response.body()!!.string())
                }
            }
        })



//        try {
//            client.newCall(request).enqueue.( { response ->
//                if (!response.isSuccessful) {
//                    throw IOException("Запрос к серверу не был успешен:" +
//                            " ${response.code()} ${response.message()}")
//                }
//                // пример получения конкретного заголовка ответа
//                Log.d ("Maalmi_Json","checkUser: Server: ${response.header("Server")}")
//                println("Server: ${response.header("Server")}")
//                // вывод тела ответа
//                Log.d ("Maalmi_Json","checkUser: response: ${response.body()!!.string()}")
//                println(response.body()!!.string())
//            })
//        } catch (e: IOException) {
//            Log.d ("Maalmi_Json","checkUser: Ошибка подключения: $e }")
//            println("Ошибка подключения: $e");
//        }


        if (! isOnline(context)) {
            return AuthResponse().apply { resultCode = - 1 }
        }
        return AuthResponse().apply { resultCode = 600 }
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