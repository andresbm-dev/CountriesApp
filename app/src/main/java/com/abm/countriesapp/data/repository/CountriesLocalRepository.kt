package com.abm.countriesapp.data.repository

import com.abm.countriesapp.data.database.CountriesEntity

interface CountriesLocalRepository {
    suspend fun getAllCountriesDao (): List<CountriesEntity>
    suspend fun insertCountries(countries: CountriesEntity)
}