package com.example.appexam.data.network

import com.example.appexam.data.model.EmpleadosResponse
import com.example.appexam.data.model.FiltroEmpleadosRequest
import com.example.appexam.data.model.UserModel
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ExamApiClient {
    //https://eland-dk.humaneland.net/HumaneTime/api/Authorization/AccesoUsuario
    //https://eland-dk.humaneland.net/HumaneTime/api/AdministracionEmpleados/BusquedaEmpleado
    @Multipart
    @POST("Authorization/AccesoUsuario")
    suspend fun loginUser(
        @Part email: MultipartBody.Part,
        @Part password: MultipartBody.Part
    ): Response<UserModel>

    @POST("AdministracionEmpleados/BusquedaEmpleado")
    suspend fun getEmpleados(
        @Body filtroEmpleadosRequest: FiltroEmpleadosRequest,
        @Header("Authorization") authorization: String
    ): Response<EmpleadosResponse>



}