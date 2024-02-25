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

    fun checkUser (user: String, pass: String) {
        _stateLiveData.postValue(ServicesGzState.Loading)
        Log.d("MAALMI_AuthViewModel", "checkUser: $user, $pass")
        val userResult = servicesGzInteractor.checkUser(user, pass)
        processResult (userResult)
    }

    fun fillData() {
        _stateLiveData.postValue(ServicesGzState.Loading)
        viewModelScope.launch {

        }
    }

    private fun processResult(service: ArrayList<String>) {
        if (service.size==0) {
            _stateLiveData.postValue(ServicesGzState.Empty(context.getString(R.string.empty_favorites)))
        } else {
            _stateLiveData.postValue(ServicesGzState.Content(service))
        }
    }

}