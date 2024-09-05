package com.example.appexam.data.network

import com.example.appexam.data.model.RequestLogin
import com.example.appexam.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ExamService @Inject constructor(
    private val api : ExamApiClient
) {
    suspend fun loginService(requestLogin: RequestLogin) : UserModel? {
        return withContext(Dispatchers.IO){
            val response = api.login(requestLogin)
            response.body()
            //response.body() ? : null //Se podría dar otro tratamiento
        }
    }

}