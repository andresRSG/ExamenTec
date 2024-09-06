package com.example.appexam.data.network

import com.example.appexam.data.model.RequestLogin
import com.example.appexam.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import javax.inject.Inject

class ExamService @Inject constructor(
    private val api : ExamApiClient
) {

    //
    suspend fun loginService(requestLogin: RequestLogin): UserModel? {
        return withContext(Dispatchers.IO) {

            val requestBody = MultipartBody.Builder()
                .addFormDataPart("email", requestLogin.email)
                .addFormDataPart("password", requestLogin.password)
                .build()

            val response = api.loginUser( requestBody.part(0), requestBody.part(1))
            response.body()
        }
    }


    //si recibiera un body
    /*suspend fun loginService(requestLogin: RequestLogin) : UserModel? {
        return withContext(Dispatchers.IO){
            val response = api.login(requestLogin)
            response.body()
            //response.body() ? : null //Se podría dar otro tratamiento
        }
    }*/



}