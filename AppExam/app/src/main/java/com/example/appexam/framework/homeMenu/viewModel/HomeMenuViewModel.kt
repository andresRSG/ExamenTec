package com.example.appexam.framework.homeMenu.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appexam.data.model.UserSesion
import com.example.appexam.domain.DeleteUserSesion
import com.example.appexam.domain.GetUserSesion
import com.example.appexam.domain.SaveUserSesion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeMenuViewModel @Inject constructor(

    private val saveUserSesion: SaveUserSesion,
    private val deleteUserSesion: DeleteUserSesion,
    private val getUserSesion: GetUserSesion

) : ViewModel() {

    private val _userSesion = MutableLiveData<UserSesion>()
    val userSesion: LiveData<UserSesion> = _userSesion

    private val _isShowProgressBar = MediatorLiveData<Boolean>()
    val isShowProgressBar: LiveData<Boolean> = _isShowProgressBar
    private val _isSesionActiva = MediatorLiveData<Boolean>()
    val isSesionActiva: LiveData<Boolean> = _isSesionActiva





    fun checkSesion(){
        viewModelScope.launch {
            val result = getUserSesion()
            if(result != null && !result.token.isNullOrEmpty()){
                _userSesion.value = result.copy()
            }
        }
    }

    fun closeSesion(){
        viewModelScope.launch {
            _isShowProgressBar.value = true
            deleteUserSesion()
            _isShowProgressBar.value = false
            _isSesionActiva.value = false
        }
    }






}