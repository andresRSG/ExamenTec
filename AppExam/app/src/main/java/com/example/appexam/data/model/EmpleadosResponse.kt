package com.example.appexam.data.model

import com.google.gson.annotations.SerializedName

data class EmpleadosResponse(
    @SerializedName("codigo") val codigo: String,
    @SerializedName("totalRegistros") val totalRegistros: Int,
    @SerializedName("empleado") val empleado: List<Empleado>
) {
    data class Empleado(
        @SerializedName("idCia") val idCia: Int,
        @SerializedName("idEmpleado") val idEmpleado: Int,
        @SerializedName("nombre") val nombre: String,
        @SerializedName("apellidoPat") val apellidoPat: String,
        @SerializedName("apellidoMat") val apellidoMat: String,
        @SerializedName("fechaIngreso") val fechaIngreso: String,
        @SerializedName("estatus") val estatus: String,
        @SerializedName("aviso") val aviso: Boolean
    )
}
