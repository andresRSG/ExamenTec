package com.example.appexam.framework.homeMenu.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appexam.R
import com.example.appexam.framework.homeMenu.ui.adapters.EmpleadosAdapter
import com.example.appexam.framework.homeMenu.viewModel.FEmpleadosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentEmpleados(val token:String) : Fragment() {

    val viewModel : FEmpleadosViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_empleados, container, false)
        val tvEmpleados = view.findViewById<TextView>(R.id.tv_noEmpleados)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler)
        val vw = view.findViewById<View>(R.id.viewProgressBar)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)

        viewModel.onCreate(token)
        viewModel.getEmpleados()


        viewModel.isEmpleadosEmpty.observe( viewLifecycleOwner, Observer{ isEmpty ->
            if(isEmpty){
                tvEmpleados.visibility = View.VISIBLE
            }else{
                tvEmpleados.visibility = View.GONE
            }
        })

        viewModel.listaEmpleados.observe(viewLifecycleOwner, Observer { empleados ->
            val adapter = EmpleadosAdapter(empleados)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(getContext())
        })

        viewModel.isShowProgressBar.observe(viewLifecycleOwner , Observer { isShow ->
            if(isShow){
                vw.visibility = View.VISIBLE
                progressBar.visibility = View.VISIBLE
            }else{

                vw.visibility = View.GONE
                progressBar.visibility = View.GONE

            }

        } )

        vw.setOnClickListener {  }

        return view
    }
}