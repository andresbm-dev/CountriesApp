package com.abm.countriesapp.domain.usecase

import com.abm.countriesapp.domain.model.Countries

interface GetCountriesApiUseCase {
    suspend fun invoke() : List<Countries>
}