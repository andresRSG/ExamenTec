package com.example.appexam.data.model

import com.example.appexam.data.model.UserModel.Acceso
import com.example.appexam.data.model.UserModel.UsuarioeTime
import com.google.gson.annotations.SerializedName

data class UserSesion(
    @SerializedName("token") val token: String,
    @SerializedName("acceso") val acceso: Acceso,
    @SerializedName("foto") val foto: String,
    @SerializedName("usuarioeTime") val usuarioeTime: UsuarioeTime
){
    data class UsuarioeTime(
        @SerializedName("idUsuario") val idUsuario: Int,
        @SerializedName("nombreCompleto") val nombreCompleto: String,
        @SerializedName("nombre") val nombre: String,
        @SerializedName("apellidoPat") val apellidoPat: String,
        @SerializedName("apellidoMat") val apellidoMat: String,
        @SerializedName("tipoUsuario") val tipoUsuario: Int,
        @SerializedName("foto") val foto: String
    )
}
