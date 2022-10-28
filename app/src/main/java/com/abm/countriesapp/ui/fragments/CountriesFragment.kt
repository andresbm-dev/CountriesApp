package com.abm.countriesapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.abm.countriesapp.R
import com.abm.countriesapp.databinding.FragmentCountriesBinding
import com.abm.countriesapp.domain.model.Countries
import com.abm.countriesapp.ui.adapter.CountriesAdapter
import com.abm.countriesapp.ui.viewmodel.CountriesViewModelImp


class CountriesFragment : Fragment() {
    private lateinit var binding: FragmentCountriesBinding
    private lateinit var viewModel: CountriesViewModelImp
    private lateinit var navigation: NavController
    private lateinit var countryAdapter: CountriesAdapter
    private var countriesMutable = mutableListOf<Countries>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCountriesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigation = Navigation.findNavController(view)
        viewModel = ViewModelProvider(requireActivity())[CountriesViewModelImp::class.java]

        binding.etSearch.addTextChangedListener { filter ->
            val countriesFilters = countriesMutable.filter { country ->
                country.nameCountry?.nameCommon?.lowercase()
                    ?.contains(filter.toString().lowercase())!!
            }
            countryAdapter.updateCountries(countriesFilters)
        }

        viewModel.getCountriesApi()
        viewModel.countries.observe(viewLifecycleOwner) { countries ->
            if (!countries.isNullOrEmpty()) {
                countriesMutable = countries as MutableList<Countries>
                countryAdapter = CountriesAdapter(countries) {
                    goDetailCountryFragment(it)
                }
                binding.rvCountries.apply {
                    adapter = countryAdapter
                    layoutManager = LinearLayoutManager(requireActivity())
                }
            }
        }
    }

    private fun goDetailCountryFragment(countries: Countries) {
        viewModel.sendParams(countries)
        navigation.navigate(R.id.detailCountriesFragment)
    }

}