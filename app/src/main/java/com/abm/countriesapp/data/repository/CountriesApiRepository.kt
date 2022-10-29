package com.abm.countriesapp.data.repository

import com.abm.countriesapp.data.database.CountriesEntity
import com.abm.countriesapp.domain.model.Countries

interface CountriesApiRepository {
    suspend fun getCountriesApi() : List<Countries>
}