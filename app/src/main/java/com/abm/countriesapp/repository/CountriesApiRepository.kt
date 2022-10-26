package com.abm.countriesapp.repository

import com.abm.countriesapp.model.usecase.ResponseCountries

interface CountriesApiRepository {

    suspend fun getCountriesApi()
}