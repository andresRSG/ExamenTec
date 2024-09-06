package com.example.appexam.data.core

import android.content.SharedPreferences
import com.example.appexam.data.model.UserSesion
import com.google.gson.Gson
import javax.inject.Inject

class UserPreferencesManager @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson
){
    private val USUARIO_KEY = "USER_SESION"

    fun guardarUsuario(usuario: UserSesion) {
        val editor = sharedPreferences.edit()
        val usuarioJson = gson.toJson(usuario)
        editor.putString(USUARIO_KEY, usuarioJson)
        editor.apply()
    }

    fun obtenerUsuario(): UserSesion? {
        val usuarioJson = sharedPreferences.getString(USUARIO_KEY, null)
        return usuarioJson?.let { gson.fromJson(it, UserSesion::class.java) }
    }

    fun eliminarUsuario() {
        val editor = sharedPreferences.edit()
        editor.remove(USUARIO_KEY)
        editor.apply()
    }

}