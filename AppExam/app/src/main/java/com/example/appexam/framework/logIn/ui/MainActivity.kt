package com.example.appexam.framework.logIn.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.appexam.databinding.ActivityMainBinding
import com.example.appexam.framework.homeMenu.ui.HomeMenu
import com.example.appexam.framework.logIn.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint //Sele informa a la actividad que tendra inyeccion de dependencias
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    lateinit var dialogErrorFragment: DialogErrorFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.checkSesion()

        viewModel.isSesionActiva.observe(this, Observer {
            val intent = Intent(this, HomeMenu::class.java)
            startActivity(intent)
        })

        binding.txInputEmail.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                viewModel.onEmailChanged(s.toString())

            }
        })

        binding.txInputPassword.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                viewModel.onPasswordChanged(s.toString())

            }
        })

        viewModel.isButtonEnabled.observe(this) { isEnabled ->
            binding.btnEntrar.isEnabled = isEnabled
        }

        viewModel.showErrorDialog.observe(this) { show ->
            if(show){
                dialogErrorFragment =  DialogErrorFragment(viewModel.textError.value!!)
                dialogErrorFragment.show(supportFragmentManager, "errorDialog")
            }else{
                try {
                    dialogErrorFragment.dismiss()
                }catch (ex :Exception){

                }
            }
        }

        viewModel.isShowProgressBar.observe(this, Observer { isShow ->
            if(isShow){
                binding.progressBar.visibility = View.VISIBLE
                binding.viewProgressBar.visibility = View.VISIBLE
                //cerrar el teclado
                val view = currentFocus ?: View(this)
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }else{
                binding.progressBar.visibility = View.GONE
                binding.viewProgressBar.visibility = View.GONE
            }
        })

        viewModel.loginInit.observe(this, Observer { resut ->
            val intent = Intent(this, HomeMenu::class.java)
            startActivity(intent)
        })

        //listeners
        binding.btnEntrar.setOnClickListener {
            viewModel.doLogin()
        }
        binding.viewProgressBar.setOnClickListener {  }



    }
}