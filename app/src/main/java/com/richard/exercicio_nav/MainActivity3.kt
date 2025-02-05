package com.richard.exercicio_nav

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.richard.exercicio_nav.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var drawer1: DrawerLayout
    lateinit var navDrawer1: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        drawer1 = binding.root
        navDrawer1 = binding.navView1

        setupToolBar()
        setupDrawerResult()
        setupDrawerResult1()
    }

    private fun setupToolBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        drawer1.openDrawer(GravityCompat.START)
        return true
    }

    private fun setupDrawerResult() {
        navDrawer1.setNavigationItemSelectedListener { menuItem ->
            drawer1.closeDrawers()
            when(menuItem.itemId){
                R.id.bottom_option_1 ->{
                   onBackPressed()
                    true
                }
                else -> false
            }
        }
    }
    private fun setupDrawerResult1() {
        navDrawer1.setNavigationItemSelectedListener { menuItem ->
            drawer1.closeDrawers()
            when (menuItem.itemId) {
                R.id.bottom_option_2 -> {
                    val intent = Intent(this, MainActivity3::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.second_screen_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.meu_settings ->{
                onBackPressed()
                true
            }
            else-> false
        }
    }
}