package com.example.appexam.domain

import com.example.appexam.data.ExamRepository
import com.example.appexam.data.core.JsonManager
import javax.inject.Inject

class GetErrorUseCase @Inject constructor(
    private val repository: JsonManager
) {

    suspend operator fun invoke(codeError: String) : String?{
        var error: String? =  repository.getMensajeByCodigo(codeError)
        val result = repository.leerCodigos()
        if(result.isNullOrEmpty()){
            return ""
        }else{
            error = repository.getMensajeByCodigo(codeError)
            if(error.isNullOrEmpty()){
                return ""
            }else{
                return error
            }
        }
    }

}