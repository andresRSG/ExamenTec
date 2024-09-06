package com.example.appexam.domain

import com.example.appexam.data.ExamRepository
import com.example.appexam.data.model.RequestLogin
import com.example.appexam.data.model.UserModel
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: ExamRepository
) {
    suspend operator fun invoke(requestLogin: RequestLogin) : UserModel?
    = repository.loginRepository(requestLogin)
}