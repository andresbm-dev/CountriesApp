package com.abm.countriesapp.repository

import com.abm.countriesapp.model.usecase.Countries
import com.abm.countriesapp.model.usecase.ResponseCountries
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(".")
    suspend fun getCountriesUrlBasic() : Response<List<Countries>>

}