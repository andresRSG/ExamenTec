package com.example.appexam.framework.logIn.viewModel

import androidx.lifecycle.ViewModel
import com.example.appexam.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    

}