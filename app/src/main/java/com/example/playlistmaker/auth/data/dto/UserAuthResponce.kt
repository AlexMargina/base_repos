package com.example.playlistmaker.auth.data.dto

import com.example.playlistmaker.search.data.dto.Response
import com.example.playlistmaker.search.data.dto.TrackDto


class UserAuthResponce (val resultCount: Int,val results: List<String>) : AuthResponse()
//Класс, который принимает ответ от сервера