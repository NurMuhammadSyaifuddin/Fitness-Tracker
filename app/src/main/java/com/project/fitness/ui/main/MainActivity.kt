package com.project.fitness.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.project.fitness.R
import com.project.fitness.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpToolbar()

        setNavController()
    }

    private fun setNavController() {
        val navController = findNavController(R.id.nav_host_controller)

        val appConfiguration = AppBarConfiguration.Builder(
            R.id.nav_news,
            R.id.nav_training,
            R.id.nav_schedule,
            R.id.nav_history
        ).build()

        setupActionBarWithNavController(navController, appConfiguration)
        binding.bottomNavbar.setupWithNavController(navController)
    }

    private fun setUpToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.elevation = 0f
    }
}