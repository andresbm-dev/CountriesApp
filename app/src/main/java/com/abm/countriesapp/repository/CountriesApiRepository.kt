package com.abm.countriesapp.repository

import com.abm.countriesapp.model.usecase.Countries

interface CountriesApiRepository {

    suspend fun getCountriesApi() : List<Countries>
}