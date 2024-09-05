package com.example.appexam.framework.logIn.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.appexam.R
import com.example.appexam.framework.logIn.viewModel.MainViewModel


class DialogErrorFragment(val errorText : String, val viewModel: MainViewModel) : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState:Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dialog_error, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnAceptar : Button = view.findViewById(R.id.btn_aceptar)
        val tvErrorText : TextView = view.findViewById(R.id.tv_errorText)

        tvErrorText.text = errorText

        btnAceptar.setOnClickListener {
            viewModel.closeErrorDialog()
        }


    }
}