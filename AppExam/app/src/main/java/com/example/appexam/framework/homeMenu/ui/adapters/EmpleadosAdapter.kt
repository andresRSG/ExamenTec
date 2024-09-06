package com.example.appexam.framework.homeMenu.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.appexam.R
import com.example.appexam.data.model.EmpleadosResponse

class EmpleadosAdapter (private val empleados : List<EmpleadosResponse.Empleado>) :RecyclerView.Adapter<EmpleadosAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvNum : TextView = itemView.findViewById(R.id.tvNum)
        val tvName : TextView = itemView.findViewById(R.id.tvName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_empleados_adapter, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int = empleados.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = empleados[position]
        //holder.tvNum.text = item.idEmpleado.toString()
        holder.tvNum.text = item.idEmpleado.toString()
        holder.tvName.text = item.nombre

    }


}