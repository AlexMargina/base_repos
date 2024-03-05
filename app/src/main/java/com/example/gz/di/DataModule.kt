package com.example.gz.di

import android.content.Context
import android.media.MediaPlayer
import androidx.room.Room
import com.example.gz.MUSIC_MAKER_PREFERENCES
import com.example.gz.auth.data.internet.HttpConnection
import com.example.gz.auth.data.internet.HttpUrlConnection
import com.example.gz.auth.data.internet.JsonClient
import com.example.gz.auth.data.internet.JsonRocClient
import com.example.gz.auth.data.internet.RetrofitRocClient
import com.example.gz.auth.data.internet.RocApi
import com.example.gz.auth.data.internet.RocClient
import com.example.gz.media.data.db.AppDatabase
import com.example.gz.search.data.network.ITunesSearchApi
import com.example.gz.search.data.network.NetworkClient
import com.example.gz.search.data.network.RetrofitNetworkClient
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