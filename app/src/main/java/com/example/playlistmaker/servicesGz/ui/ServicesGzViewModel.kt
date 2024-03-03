package com.example.playlistmaker.servicesGz.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playlistmaker.R
import com.example.playlistmaker.servicesGz.domain.ServicesGzInteractor
import kotlinx.coroutines.launch


class ServicesGzViewModel (
    private val context: Context,
    private val servicesGzInteractor: ServicesGzInteractor
) : ViewModel() {

    private val _stateLiveData = MutableLiveData<ServicesGzState>()
    val stateLiveData: LiveData<ServicesGzState> = _stateLiveData

    init {

        Log.d("MAALMI_FavoriteViewModel", "init")
    }

    fun getServices (position: String) {
        _stateLiveData.postValue(ServicesGzState.Loading)
        Log.d("MAALMI_AuthViewModel", "checkUser: $position, ")
        viewModelScope.launch {
            val userResult = servicesGzInteractor.getServices(position)
            processResult(userResult)
        }
    }



    private fun processResult(services: ArrayList<String>) {
        if (services.size>0) {
             _stateLiveData.postValue(ServicesGzState.Content(services))
        } else {
            _stateLiveData.postValue(ServicesGzState.Empty(context.getString(R.string.empty_favorites)))
        }
    }

}