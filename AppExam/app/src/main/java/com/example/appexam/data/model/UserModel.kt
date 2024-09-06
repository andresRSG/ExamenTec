package com.example.appexam.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(

    @SerializedName("token") val token: String,
    @SerializedName("error") val error: Boolean,
    @SerializedName("codigo") val codigo: String,
    @SerializedName("acceso") val acceso: Acceso,
    @SerializedName("foto") val foto: String?
    ) {
        data class Acceso(
            @SerializedName("codigo") val codigo: String,
            @SerializedName("ambiente") val ambiente: String,
            @SerializedName("expiration") val expiration: Boolean,
            @SerializedName("usuarioeTime") val usuarioeTime: UsuarioeTime
        )

        data class UsuarioeTime(
            @SerializedName("idUsuario") val idUsuario: Int,
            @SerializedName("nombreCompleto") val nombreCompleto: String,
            @SerializedName("nombre") val nombre: String,
            @SerializedName("apellidoPat") val apellidoPat: String,
            @SerializedName("apellidoMat") val apellidoMat: String,
            @SerializedName("tipoUsuario") val tipoUsuario: Int,
            @SerializedName("foto") val foto: String?
        )
    }
