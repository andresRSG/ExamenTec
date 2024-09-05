package com.example.appexam.framework.logIn.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.appexam.framework.homeMenu.ui.HomeMenu
import com.example.appexam.databinding.ActivityMainBinding
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
                dialogErrorFragment =  DialogErrorFragment("Error Genérico", viewModel )
                dialogErrorFragment.show(supportFragmentManager, "myDialog")
            }else{
                try {
                    dialogErrorFragment.dismiss()
                }catch (ex :Exception){

                }
            }
        }

        //listeners
        binding.btnEntrar.setOnClickListener {
            viewModel.logIn()

        //val intent = Intent(this, HomeMenu::class.java)
            //startActivity(intent)
        }



    }
}