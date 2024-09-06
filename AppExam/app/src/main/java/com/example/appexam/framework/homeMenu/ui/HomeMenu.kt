package com.example.appexam.framework.homeMenu.ui

import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import com.example.appexam.R
import com.google.android.material.navigation.NavigationView

class HomeMenu : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var drawer: DrawerLayout
    private lateinit var toogle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_menu)

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

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()


        when(item.itemId){
            R.id.nav_item_datos_compania ->{
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_supervisores -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_zonas -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_estaciones -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_empleados -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_estaciones -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_reportes -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_historial -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_cambiar_password -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_item_cerrar_sesion -> {
                Toast.makeText(this, "${item.title}", Toast.LENGTH_SHORT).show()
            }
        }

        drawer.closeDrawer(GravityCompat.START)

        //setTitle(item.title)
        setTitle("")

        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?){
        super.onPostCreate(savedInstanceState)
        toogle.syncState()
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