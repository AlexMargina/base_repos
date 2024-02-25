package com.example.playlistmaker.auth.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playlistmaker.R
import com.example.playlistmaker.auth.domain.AuthInteractor
import kotlinx.coroutines.launch


class AuthViewModel (
    private val context: Context,
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _stateLiveData = MutableLiveData<AuthState>()
    val stateLiveData: LiveData<AuthState> = _stateLiveData

    init {

        Log.d("MAALMI_FavoriteViewModel", "init")
    }

    fun checkUser (user: String, pass: String) {
        _stateLiveData.postValue(AuthState.Loading)
        Log.d("MAALMI_AuthViewModel", "checkUser: $user, $pass")
        val userResult = authInteractor.checkUser()
        processResult (userResult)
    }

    fun fillData() {
        _stateLiveData.postValue(AuthState.Loading)
        viewModelScope.launch {

        }
    }

    private fun processResult(service: ArrayList<String>) {
        if (service.size==0) {
            _stateLiveData.postValue(AuthState.Empty(context.getString(R.string.empty_favorites)))
        } else {
            _stateLiveData.postValue(AuthState.Content(service))
        }
    }

}