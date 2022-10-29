package com.abm.countriesapp.ui.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.abm.countriesapp.R
import com.abm.countriesapp.data.database.CountriesEntity
import com.abm.countriesapp.databinding.FragmentCountriesBinding
import com.abm.countriesapp.domain.model.Countries
import com.abm.countriesapp.ui.adapter.CountriesAdapter
import com.abm.countriesapp.ui.adapter.CountriesLocalAdapter
import com.abm.countriesapp.ui.viewmodel.CountriesViewModelImp


class CountriesFragment : Fragment() {
    private lateinit var binding: FragmentCountriesBinding
    private lateinit var viewModel: CountriesViewModelImp
    private lateinit var navigation: NavController
    private lateinit var countryAdapter: CountriesAdapter
    private lateinit var countryLocalAdapter: CountriesLocalAdapter

    private var countriesMutable = mutableListOf<Countries>()
    private var countriesLocalMutable = mutableListOf<CountriesEntity>()


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
        viewModel.getCountriesApi()

        initObservers()
        initListener()
    }


    private fun initObservers() {
        viewModel.countries.observe(viewLifecycleOwner) { countries ->
            if (!countries.isNullOrEmpty()) {
                countriesMutable = countries as MutableList<Countries>
                countryAdapter = CountriesAdapter(countries) {
                    goDetailCountryFragment(it)
                }
                binding.rvCountries.apply {
                    adapter = countryAdapter
                    layoutManager = GridLayoutManager(requireActivity(), 2)
                }
                Toast.makeText(requireActivity(),"Paises descargados desde internet",Toast.LENGTH_SHORT).show()
                binding.rvCountries.visibility = View.VISIBLE
                binding.title.text = getString(R.string.countries_api)

            } else {
                viewModel.getCountriesLocal()
                binding.rvCountries.visibility = View.GONE
            }
        }

        viewModel.countriesDataBase.observe(viewLifecycleOwner) { countriesLocal ->
            if (countriesLocal != null) {
                countriesLocalMutable = countriesLocal as MutableList<CountriesEntity>
                countryLocalAdapter = CountriesLocalAdapter(countriesLocal)
                binding.rvCountriesLocal.apply {
                    adapter = countryLocalAdapter
                    layoutManager = GridLayoutManager(requireActivity(), 2)
                }
                binding.rvCountriesLocal.visibility = View.VISIBLE
                binding.title.text = getString(R.string.countries_local)

            }
            Toast.makeText(requireActivity(),"Paises cargados desde base de datos",Toast.LENGTH_SHORT).show()
        }
    }

    private fun initListener() {

        binding.etSearch.addTextChangedListener { filter ->
            if (countriesMutable.isNotEmpty()) {
                val countriesFilters = countriesMutable.filter { country ->
                    country.nameCountry?.nameOfficial?.lowercase()
                        ?.contains(filter.toString().lowercase())!!
                }
                countryAdapter.updateCountries(countriesFilters)
            } else if (countriesLocalMutable.isNotEmpty()) {
                val countriesLocalFilters = countriesLocalMutable.filter { country ->
                    country.nameCountry?.lowercase()
                        ?.contains(filter.toString().lowercase())!!
                }
                countryLocalAdapter.updateCountries(countriesLocalFilters)
            }
        }
    }

    private fun goDetailCountryFragment(countries: Countries) {
        viewModel.sendParams(countries)
        navigation.navigate(R.id.detailCountriesFragment)
    }

}