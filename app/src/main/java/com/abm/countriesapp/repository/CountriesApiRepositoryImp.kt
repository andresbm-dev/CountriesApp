package com.abm.countriesapp.repository


import javax.inject.Inject

class CountriesApiRepositoryImp @Inject constructor(
 private val apiService: ApiService
) : CountriesApiRepository {
    override suspend fun getCountriesApi()  {
        val countries = apiService.getCountriesUrlBasic()
        val body = countries.body()
        if (body != null)
        println("body $body")

    }

}