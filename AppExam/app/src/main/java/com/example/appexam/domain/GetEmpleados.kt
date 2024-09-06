package com.example.appexam.domain

import com.example.appexam.data.ExamRepository
import com.example.appexam.data.model.EmpleadosResponse
import com.example.appexam.data.model.FiltroEmpleadosRequest
import javax.inject.Inject

class GetEmpleados @Inject constructor(
    private val repository: ExamRepository
) {
    suspend operator fun invoke(filtroEmpleadosRequest: FiltroEmpleadosRequest, token : String) : List<EmpleadosResponse.Empleado>?{
        return repository.getEmpleados(filtroEmpleadosRequest, token)
    }


}