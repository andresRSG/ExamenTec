package com.example.appexam.data.core

import android.content.Context
import com.example.appexam.data.model.ErrorCodeModel
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

class JsonManager @Inject constructor(
    private val context: Context
) {
    private val gson = Gson()
    private var codigosMensajes: List<ErrorCodeModel>? = null

    fun leerCodigos(): List<ErrorCodeModel> {
        if (codigosMensajes == null) {
            val inputStream = context.assets.open("codigos_error.json")
            val reader = BufferedReader(InputStreamReader(inputStream))
            val json = reader.readText()
            codigosMensajes = gson.fromJson(json, Array<ErrorCodeModel>::class.java).toList()
        }
        return codigosMensajes ?: emptyList()
    }

    fun getMensajeByCodigo(codigo: String): String? {
        return codigosMensajes?.find { it.CODIGO == codigo }?.MENSAJE
    }
}