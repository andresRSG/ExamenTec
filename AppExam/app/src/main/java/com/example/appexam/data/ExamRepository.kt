package com.example.appexam.data

import com.example.appexam.data.model.RequestLogin
import com.example.appexam.data.model.UserModel
import com.example.appexam.data.network.ExamService
import okhttp3.MultipartBody
import javax.inject.Inject

class ExamRepository @Inject constructor(
    private val api : ExamService
) {

    suspend fun loginRepository(requestLogin: RequestLogin) : UserModel? {
        val response = api.loginService(requestLogin)
        return response //tomar en cuenta que podría ser null
    }



}