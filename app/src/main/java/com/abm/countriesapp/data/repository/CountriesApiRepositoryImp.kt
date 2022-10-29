package com.abm.countriesapp.data.repository

import com.abm.countriesapp.data.remote.ApiService
import com.abm.countriesapp.domain.model.Countries
import javax.inject.Inject

class CountriesApiRepositoryImp @Inject constructor(
    private val apiService: ApiService
) : CountriesApiRepository {
    override suspend fun getCountriesApi(): List<Countries>{
        return try {
            val response = apiService.getCountriesUrlBasic()
            response.body() ?: emptyList()
        }catch (e :Exception){
            emptyList()
        }
    }
}