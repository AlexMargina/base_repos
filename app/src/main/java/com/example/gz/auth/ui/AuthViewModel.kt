package com.example.gz.auth.ui

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gz.auth.domain.AuthInteractor
import com.example.playlistmaker.R
import kotlinx.coroutines.launch


class AuthViewModel (
    private val context: Context,
    private val authInteractor: AuthInteractor
) : ViewModel() {

    private val _stateLiveData = MutableLiveData<AuthState>()
    val stateLiveData: LiveData<AuthState> = _stateLiveData

    fun checkUser (user: String, pass: String) {
        _stateLiveData.postValue(AuthState.Loading)
        var responceCheckUser = ""
        val userResult = arrayListOf<String>()
        viewModelScope.launch {

            Log.d("MAALMI_AuthViewModel_1", "checkUser: $user, $pass")
            responceCheckUser = authInteractor.checkUser(user, pass)
            //userResult.addAll (authInteractor.checkUser(user, pass))
            Log.d("MAALMI_AuthViewModel_2", "userResult: ${userResult.size}, ${userResult.toString()}")
            processResult (responceCheckUser)
        }
        Log.d("MAALMI_AuthViewModel_3", "userResult: ${userResult.size}, ${userResult.toString()}")

    }

    private fun processResult(responceCheckUser: String) {
        Log.d("MAALMI_AuthViewModel_4", "userResult: ${responceCheckUser.length}, ${responceCheckUser}")
        if (responceCheckUser.length >1) {
            _stateLiveData.postValue(AuthState.Content(responceCheckUser))
        } else {
            _stateLiveData.postValue(AuthState.Empty(context.getString(R.string.empty_favorites)))
        }
    }
}