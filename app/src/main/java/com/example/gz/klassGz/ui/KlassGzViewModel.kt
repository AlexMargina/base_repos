package com.example.gz.klassGz.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gz.klassGz.domain.KlassGzInteractor
import com.example.gz.servicesGz.ui.ServicesGzState

class KlassGzViewModel (val interactor: KlassGzInteractor) : ViewModel() {

    private val _stateLiveData = MutableLiveData<ServicesGzState>()
    val stateLiveData: LiveData<ServicesGzState> = _stateLiveData

}
