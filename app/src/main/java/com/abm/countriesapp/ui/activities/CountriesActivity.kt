package com.abm.countriesapp.ui.activities

import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.abm.countriesapp.R
import com.abm.countriesapp.databinding.ActivityMainBinding
import com.abm.countriesapp.ui.viewmodel.CountriesViewModelImp
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CountriesActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.countriesFragment)
    }

}