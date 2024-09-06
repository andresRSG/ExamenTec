package com.example.appexam.domain

import com.example.appexam.data.ExamRepository
import com.example.appexam.data.model.UserSesion
import javax.inject.Inject

class GetUserSesion @Inject constructor(
    private val repository: ExamRepository
) {
    suspend operator fun invoke() : UserSesion? {
        try {
            val result =  repository.getUserSesion()
            return result
        }catch (ex : Exception){
            return null
        }

    }


}