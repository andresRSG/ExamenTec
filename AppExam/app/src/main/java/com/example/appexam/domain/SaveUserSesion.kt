package com.example.appexam.domain

import com.example.appexam.data.ExamRepository
import com.example.appexam.data.model.UserSesion
import javax.inject.Inject

class SaveUserSesion @Inject constructor(
    private val repository: ExamRepository
) {

    suspend operator fun invoke(user : UserSesion){
        repository.saveUserSesion(user)
    }

}