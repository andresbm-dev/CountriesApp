package com.abm.countriesapp.data.remote

import com.abm.countriesapp.domain.model.Countries
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(".")
    suspend fun getCountriesUrlBasic() : Response<List<Countries>>

}