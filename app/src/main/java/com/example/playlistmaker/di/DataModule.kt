package com.example.playlistmaker.di

import android.content.Context
import android.media.MediaPlayer
import androidx.room.Room
import com.example.playlistmaker.MUSIC_MAKER_PREFERENCES
import com.example.playlistmaker.auth.data.internet.HttpConnection
import com.example.playlistmaker.auth.data.internet.HttpUrlConnection
import com.example.playlistmaker.auth.data.internet.JsonClient
import com.example.playlistmaker.auth.data.internet.JsonRocClient
import com.example.playlistmaker.auth.data.internet.RetrofitRocClient
import com.example.playlistmaker.auth.data.internet.RocApi
import com.example.playlistmaker.auth.data.internet.RocClient
import com.example.playlistmaker.media.data.db.AppDatabase
import com.example.playlistmaker.search.data.network.ITunesSearchApi
import com.example.playlistmaker.search.data.network.NetworkClient
import com.example.playlistmaker.search.data.network.RetrofitNetworkClient
import com.google.gson.Gson
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModule = module {

    factory <MediaPlayer>{
        MediaPlayer()
    }

    single<RocApi> {
        Retrofit.Builder()
            .baseUrl("https://roc76.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RocApi::class.java)
    }

    single <HttpConnection> {
        HttpUrlConnection(get())
    }

    single<RocClient> {
        RetrofitRocClient(get(), androidContext())
    }

    single<JsonClient> {
        JsonRocClient(get())
    }

    single<ITunesSearchApi> {
        Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ITunesSearchApi::class.java)
    }

    single {
        androidContext()
            .getSharedPreferences(MUSIC_MAKER_PREFERENCES, Context.MODE_PRIVATE)
    }


    factory { Gson() }


    single<NetworkClient> {
        RetrofitNetworkClient(get(), androidContext())
    }

    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "database.db")
            .build()
    }


}