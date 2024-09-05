package com.example.appexam.framework.logIn.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appexam.HomeMenu
import com.example.appexam.R
import com.example.appexam.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint //Sele informa a la actividad que tendra inyeccion de dependencias
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //listeners
        binding.btnEntrar.setOnClickListener {
            val intent = Intent(this, HomeMenu::class.java)
            startActivity(intent)
            
        }

    }
}