package com.example.appexam.framework.homeMenu.ui

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import com.example.appexam.R
import com.example.appexam.databinding.ActivityHomeMenuBinding
import com.example.appexam.framework.homeMenu.ui.fragments.FragmentDatosEmpresa
import com.example.appexam.framework.homeMenu.ui.fragments.FragmentGenerico
import com.example.appexam.framework.homeMenu.ui.fragments.FragmentSupervisores
import com.example.appexam.framework.homeMenu.ui.fragments.FragmentZonas
import com.example.appexam.framework.homeMenu.viewModel.HomeMenuViewModel
import com.example.appexam.framework.logIn.ui.MainActivity
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeMenu : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var drawer: DrawerLayout
    private lateinit var toogle: ActionBarDrawerToggle

    lateinit var binding: ActivityHomeMenuBinding

     private val viewModel : HomeMenuViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeMenuBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val toolbar : Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        toogle = ActionBarDrawerToggle(this, drawer, toolbar,
            R.string.nav_draw_open,
            R.string.nav_draw_close
        )
        drawer.addDrawerListener(toogle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)


        val navigationView : NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)
        setTitle("")

        viewModel.checkSesion()

        viewModel.userSesion.observe(this, Observer { user ->
            val headerText = navigationView.getHeaderView(0).findViewById<TextView>(R.id.nav_header_textView)
            headerText.text = user.nombreCompleto
        })

        viewModel.isShowProgressBar.observe(this, Observer { isShow ->
            if(isShow){
                binding.progressBar.visibility = View.VISIBLE
                binding.viewProgressBar.visibility = View.VISIBLE
            }else{
                binding.progressBar.visibility = View.GONE
                binding.viewProgressBar.visibility = View.GONE
            }
        })

        viewModel.isSesionActiva.observe(this, Observer {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        })


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        //setTitle(item.title)
        setTitle("")

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        drawer.closeDrawer(GravityCompat.START)


        when(item.itemId){
            R.id.nav_item_datos_compania ->{
                fragmentTransaction.replace(R.id.frameLayoutHome, FragmentDatosEmpresa()).commit()
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_supervisores -> {
                fragmentTransaction.replace(R.id.frameLayoutHome, FragmentSupervisores()).commit()
            }
            R.id.nav_item_zonas -> {
                fragmentTransaction.replace(R.id.frameLayoutHome, FragmentZonas()).commit()

            }
            R.id.nav_item_estaciones -> {
                fragmentTransaction.replace(R.id.frameLayoutHome, FragmentGenerico(item.title.toString())).commit()
            }
            R.id.nav_item_empleados -> {
                fragmentTransaction.replace(R.id.frameLayoutHome, FragmentGenerico(item.title.toString())).commit()
            }
            R.id.nav_item_estaciones -> {
                fragmentTransaction.replace(R.id.frameLayoutHome, FragmentGenerico(item.title.toString())).commit()

            }
            R.id.nav_item_reportes -> {
                fragmentTransaction.replace(R.id.frameLayoutHome, FragmentGenerico(item.title.toString())).commit()

            }
            R.id.nav_item_historial -> {
                fragmentTransaction.replace(R.id.frameLayoutHome, FragmentGenerico(item.title.toString())).commit()

            }
            R.id.nav_item_cambiar_password -> {
                fragmentTransaction.replace(R.id.frameLayoutHome, FragmentGenerico(item.title.toString())).commit()

            }
            R.id.nav_item_cerrar_sesion -> {
                viewModel.closeSesion()
            }
        }



        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?){
        super.onPostCreate(savedInstanceState)
        toogle.syncState()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayoutHome, FragmentDatosEmpresa()).commit()



    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toogle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)

    }
}