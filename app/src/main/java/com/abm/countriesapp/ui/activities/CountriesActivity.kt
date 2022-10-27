package com.abm.countriesapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.abm.countriesapp.R
import com.abm.countriesapp.databinding.ActivityMainBinding
import com.abm.countriesapp.ui.adapter.CountriesAdapter
import com.abm.countriesapp.ui.viewmodel.CountriesViewModelImp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountriesActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val viewModel: CountriesViewModelImp by viewModels()
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