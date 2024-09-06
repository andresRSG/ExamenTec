package com.example.appexam.data

import android.media.session.MediaSession.Token
import com.example.appexam.data.core.UserPreferencesManager
import com.example.appexam.data.model.EmpleadosResponse
import com.example.appexam.data.model.FiltroEmpleadosRequest
import com.example.appexam.data.model.RequestLogin
import com.example.appexam.data.model.UserModel
import com.example.appexam.data.model.UserSesion
import com.example.appexam.data.network.ExamService
import okhttp3.MultipartBody
import javax.inject.Inject

class ExamRepository @Inject constructor(
    private val api : ExamService,
    private val preferences : UserPreferencesManager
) {

    //flujo logIn
    suspend fun loginRepository(requestLogin: RequestLogin) : UserModel? {
        val response = api.loginService(requestLogin)
        return response //tomar en cuenta que podría ser null
    }

    //flujo de obtener empleados
    suspend fun getEmpleados(filtroEmpleadosRequest: FiltroEmpleadosRequest, token: String) : List<EmpleadosResponse.Empleado> ?{
        val response = api.getEmpleados(filtroEmpleadosRequest, token)
        return response.getOrNull()
    }


    //Flujo de uaurio sesion
    suspend fun saveUserSesion(user : UserSesion){
        preferences.guardarUsuario(user)
    }

    suspend fun deleteUserSesion(){
        preferences.eliminarUsuario()
    }

    suspend fun getUserSesion() : UserSesion? = preferences.obtenerUsuario()



}