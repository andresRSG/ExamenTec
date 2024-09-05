package com.example.appexam.data.model

import com.google.gson.annotations.SerializedName

data class FiltroEmpleadosRequest(
    @SerializedName("filtroEmpleado") val filtroEmpleado: String,
    @SerializedName("idCia") val idCia: Int,
    @SerializedName("idUsuario") val idUsuario: Int,
    @SerializedName("numRegistros") val numRegistros: Int,
    @SerializedName("pagina") val pagina: Int

)
