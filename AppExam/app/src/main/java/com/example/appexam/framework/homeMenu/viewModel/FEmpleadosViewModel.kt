package com.example.appexam.framework.homeMenu.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appexam.data.model.EmpleadosResponse
import com.example.appexam.data.model.FiltroEmpleadosRequest
import com.example.appexam.domain.GetEmpleados
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FEmpleadosViewModel @Inject constructor(
    private val getEmpleados: GetEmpleados
): ViewModel() {

    private val _listaEmpleados = MutableLiveData<List<EmpleadosResponse.Empleado>>()
    val listaEmpleados : LiveData<List<EmpleadosResponse.Empleado>> = _listaEmpleados

    private val _token = MutableLiveData<String>()
    private val token : LiveData<String> = _token

    private val _isEmpleadosEmpty = MutableLiveData<Boolean>()
    val isEmpleadosEmpty : LiveData<Boolean> = _isEmpleadosEmpty

    private val _isShowProgressBar = MediatorLiveData<Boolean>()
    val isShowProgressBar: LiveData<Boolean> = _isShowProgressBar



    fun onCreate(token:String){
        _token.value = token
    }

    fun getEmpleados(){
        viewModelScope.launch {
            _isShowProgressBar.value = true

            //RequestEstatico
            val empleadosRequest = FiltroEmpleadosRequest(
                filtroEmpleado = "",
                idUsuario = 357,
                idCia = 10046,
                numRegistros = 500,
                pagina = 1,
            )

            val result = getEmpleados(empleadosRequest, token = _token.value!!)

            if(result.isNullOrEmpty()){
                _isEmpleadosEmpty.value = true
            }else{
                _isEmpleadosEmpty.value = false
                _listaEmpleados.value = result?:emptyList()
            }

            _isShowProgressBar.value = false
        }
    }


}