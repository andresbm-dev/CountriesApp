package com.abm.countriesapp.model.usecase

interface GetCountriesApiUseCase {
    suspend fun invoke() : List<Countries>
}