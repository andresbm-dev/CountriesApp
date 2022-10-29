package com.abm.countriesapp.domain.usecase

import com.abm.countriesapp.data.database.CountriesEntity
import com.abm.countriesapp.data.repository.CountriesLocalRepositoryImp
import javax.inject.Inject

class GetCountriesLocalUseCaseImp @Inject constructor(
    private val repositoryLocalUseCaseImp:CountriesLocalRepositoryImp
):GetCountriesLocalUseCase {
    override suspend operator fun invoke(): List<CountriesEntity> {
       return repositoryLocalUseCaseImp.getAllCountriesDao()
    }
}