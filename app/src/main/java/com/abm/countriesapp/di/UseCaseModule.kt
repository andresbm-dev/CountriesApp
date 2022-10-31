package com.abm.countriesapp.di

import com.abm.countriesapp.domain.usecase.GetCountriesApiUseCase
import com.abm.countriesapp.domain.usecase.GetCountriesApiUseCaseImp
import com.abm.countriesapp.domain.usecase.GetCountriesLocalUseCase
import com.abm.countriesapp.domain.usecase.GetCountriesLocalUseCaseImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun providesCountriesApiUseCase(useCaseImp: GetCountriesApiUseCaseImp): GetCountriesApiUseCase

    @Binds
    abstract fun providesCountriesLocalUseCase(useCaseImp: GetCountriesLocalUseCaseImp): GetCountriesLocalUseCase

}