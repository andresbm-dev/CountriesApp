package com.abm.countriesapp.data.network.repository

import com.abm.countriesapp.domain.model.Countries

interface CountriesApiRepository {

    suspend fun getCountriesApi() : List<Countries>
}