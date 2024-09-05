package com.example.appexam.data.network

import com.example.appexam.data.model.EmpleadosResponse
import com.example.appexam.data.model.FiltroEmpleadosRequest
import com.example.appexam.data.model.RequestLogin
import com.example.appexam.data.model.UserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ExamApiClient {
    //https://eland-dk.humaneland.net/HumaneTime/api/Authorization/AccesoUsuario
    //https://eland-dk.humaneland.net/HumaneTime/api/AdministracionEmpleados/BusquedaEmpleado

    @POST("Authorization/AccesoUsuario")
    suspend fun login(@Body loginRequest: RequestLogin): Response<UserModel>

    @POST("AdministracionEmpleados/BusquedaEmpleado")
    suspend fun getEmpleados(
        @Body filtroEmpleadosRequest: FiltroEmpleadosRequest,
        @Header("Authorization") authorization: String
    ): Response<EmpleadosResponse>



}