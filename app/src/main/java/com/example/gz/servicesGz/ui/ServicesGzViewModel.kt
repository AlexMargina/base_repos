package com.example.gz.servicesGz.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gz.servicesGz.domain.Products
import com.example.gz.servicesGz.domain.ServicesGzInteractor
import com.example.playlistmaker.R
import kotlinx.coroutines.launch


class ServicesGzViewModel (
    private val context: Context,
    private val servicesGzInteractor: ServicesGzInteractor
) : ViewModel() {

    private val _stateLiveData = MutableLiveData<ServicesGzState>()
    val stateLiveData: LiveData<ServicesGzState> = _stateLiveData

    fun getServices (position: String) {
        _stateLiveData.postValue(ServicesGzState.Loading)
        Log.d("MAALMI_ServicesGzViewModel", "getServices: $position, ")
        viewModelScope.launch {
            val userResult = servicesGzInteractor.getServices(position)
            processResult(userResult)
        }
    }

    private fun processResult(services: ArrayList<Products>) {
        if (services.size>0) {
             _stateLiveData.postValue(ServicesGzState.Content(services))
        } else {
            _stateLiveData.postValue(ServicesGzState.Empty(context.getString(R.string.empty_favorites)))
        }
    }

}