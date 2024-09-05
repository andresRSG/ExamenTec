package com.example.appexam.framework.logIn.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appexam.domain.GetErrorUseCase
import com.example.appexam.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val getErrorUseCase: GetErrorUseCase
) : ViewModel() {

    private val _isEmailValid = MutableLiveData<Boolean>()
    val isEmailValid: LiveData<Boolean> = _isEmailValid

    private val _isPasswordValid = MutableLiveData<Boolean>()

    val isPasswordValid: LiveData<Boolean> = _isPasswordValid

    private val _isButtonEnabled = MediatorLiveData<Boolean>()
    val isButtonEnabled: LiveData<Boolean> = _isButtonEnabled

    private val _showErrorDialog = MutableLiveData<Boolean>()
    val showErrorDialog : LiveData<Boolean> = _showErrorDialog

    private val _textError = MutableLiveData<String>()
    val textError : LiveData<String> = _textError

    init {
        _isButtonEnabled.addSource(_isEmailValid) { isEmailValid ->
            val isPasswordValid = _isPasswordValid.value ?: false
            _isButtonEnabled.value = isEmailValid && isPasswordValid
        }

        _isButtonEnabled.addSource(_isPasswordValid) { isPasswordValid ->
            val isEmailValid = _isEmailValid.value ?: false
            _isButtonEnabled.value = isEmailValid && isPasswordValid
        }
    }

    fun onEmailChanged(email: String) {
        _isEmailValid.value = isValidEmail(email)
    }

    fun onPasswordChanged(password: String) {
        _isPasswordValid.value = password.length >= 6
    }

    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$".toRegex()
        return emailRegex.matches(email)
    }

    fun logIn(){
        viewModelScope.launch{
            val result : String? = getErrorUseCase("DB211")
            if(!result.isNullOrEmpty()){
                _textError.value = result.let { it }
            }else{
                _textError.value = "Error No encontrado"
            }

            _showErrorDialog.value = true

        }
    }

    fun closeErrorDialog(){
        _showErrorDialog.value = false
    }

}