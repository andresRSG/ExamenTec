package com.example.appexam.domain

import com.example.appexam.data.ExamRepository
import javax.inject.Inject


class DeleteUserSesion @Inject constructor(
    private val repository: ExamRepository
){

    suspend operator fun invoke(){
        try {
            repository.deleteUserSesion()
        }catch (ex :Exception){

        }
    }

}