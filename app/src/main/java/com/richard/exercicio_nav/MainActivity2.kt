package com.richard.exercicio_nav

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.richard.exercicio_nav.R.*
import com.richard.exercicio_nav.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav: BottomNavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar2)

        drawer = binding.root
        navDrawer = binding.navView
        bottomNav= binding.bottomNav

        setupToolBar()
        setupDrawer()
        setupBottomNavigation()
        setupDrawerResult()


    }

    private fun setupBottomNavigation(){
        bottomNav.setOnItemSelectedListener { menuItem -> when(menuItem.itemId){
            id.bottom_option_1->{
                Snackbar.make(drawer,getString(string.bottom_nav_title_1), Snackbar.LENGTH_SHORT).show()
                true
            }
            id.bottom_option_2->{ val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)
                true}
            else->false
        }
        }
    }

    private fun setupDrawer() {
        navDrawer.setNavigationItemSelectedListener { menuItem ->
            drawer.closeDrawers()
            when(menuItem.itemId){
                id.bottom_option_1 ->{
                    Snackbar.make(drawer,getString(string.bottom_nav_title_1), Snackbar.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
    private fun setupDrawerResult() {
        navDrawer.setNavigationItemSelectedListener { menuItem ->
            drawer.closeDrawers()
            when(menuItem.itemId){
                id.bottom_option_2->{
                    val intent = Intent(this, MainActivity3::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

    }
    private fun setupToolBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(drawable.ic_menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        drawer.openDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.second_screen_menu,menu)
        return true
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            id.meu_settings ->{
                onBackPressed()
                true
            }
            else-> false
        }
    }
}