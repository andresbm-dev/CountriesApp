package com.abm.countriesapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.abm.countriesapp.R
import com.abm.countriesapp.databinding.FragmentCountriesBinding
import com.abm.countriesapp.databinding.FragmentDetailCountriesBinding
import com.abm.countriesapp.ui.adapter.CountriesAdapter
import com.abm.countriesapp.ui.adapter.DetailCountryAdapter
import com.abm.countriesapp.ui.viewmodel.CountriesViewModelImp

class DetailCountriesFragment : Fragment() {
    private lateinit var binding: FragmentDetailCountriesBinding
    private lateinit var viewModel: CountriesViewModelImp
    private lateinit var navigation: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailCountriesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[CountriesViewModelImp::class.java]
        viewModel.paramCountry.observe(viewLifecycleOwner) { countries ->
            if (countries != null) {
                if (countries.borders != null) {
                    binding.rvDetailCountries.apply {
                        adapter = DetailCountryAdapter(countries.borders!!)
                        layoutManager = LinearLayoutManager(requireActivity())
                    }
                }else{
                    binding.notLimits.visibility = View.VISIBLE
                    binding.rvDetailCountries.visibility = View.GONE
                }

            }
        }
    }

    companion object {
        fun newInstance(): Fragment {
            val args = Bundle()
            val fragment = DetailCountriesFragment()
            fragment.arguments = args
            return fragment
        }
    }


}