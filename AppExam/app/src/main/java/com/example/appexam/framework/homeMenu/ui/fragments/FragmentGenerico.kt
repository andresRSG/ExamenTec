package com.example.appexam.framework.homeMenu.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.appexam.R

class FragmentGenerico(val title : String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_generico, container, false)
        val tv_title = view.findViewById<TextView>(R.id.tv_title)
        tv_title.text = title
        return view
    }
}