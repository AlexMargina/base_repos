package com.example.playlistmaker.auth.data

import android.util.Log
import com.example.playlistmaker.auth.data.dto.UserAuthRequest
import com.example.playlistmaker.auth.data.internet.HttpUrlConnection
import com.example.playlistmaker.auth.data.internet.JsonClient
import com.example.playlistmaker.auth.data.internet.RocClient
import com.example.playlistmaker.auth.domain.AuthRepository
import java.net.HttpURLConnection
import java.net.URL

class AuthRepositoryImpl(
    private val rocClient: RocClient,
    private val jsonClient: JsonClient
): AuthRepository {

    override suspend fun checkUser (user: String, pass: String): ArrayList<String> {
        val expression: String = "user='$user'&pass='$pass'"
        Log.d ("MAALMI_Repo","checkUser $expression")
        val request: UserAuthRequest = UserAuthRequest(expression)
        //val response = rocClient.doRequest(expression)
        //val response = jsonClient.checkUser(expression)
        val httpUrlConnection = HttpUrlConnection()
        val url = URL("https://gz.roc76.ru/check_user.php?user=%27Фокина%20Я.В.%27&pass=0808")
        val httpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.requestMethod = "POST"
        httpURLConnection.setRequestProperty("Content-Type", "application/json") // The format of the content we're sending to the server
        httpURLConnection.setRequestProperty("Accept", "application/json") // The format of response we want to get from the server
        httpURLConnection.doInput = true
        httpURLConnection.doOutput = true

        Log.d ("MAALMI_Repo","checkUser: connect url ${httpURLConnection.url}")
        //httpURLConnection.connect()

        val userAuthResponce = httpUrlConnection.checkUser(user, pass)
        //Log.d ("MAALMI_AuthRepo","checkUser response=${response1}")

        val result = arrayListOf<String>()

        result.add(0, userAuthResponce.results)
        //result.add(0, response.resultCode.toString())
        return result
    }
}