package com.abm.countriesapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.abm.countriesapp.CountriesCoroutineRule
import com.abm.countriesapp.data.database.CountriesEntity
import com.abm.countriesapp.domain.model.Countries
import com.abm.countriesapp.domain.model.FlagsCountries
import com.abm.countriesapp.domain.model.NameCountry
import com.abm.countriesapp.domain.usecase.GetCountriesApiUseCase
import com.abm.countriesapp.domain.usecase.GetCountriesApiUseCaseImp
import com.abm.countriesapp.domain.usecase.GetCountriesLocalUseCase
import com.abm.countriesapp.domain.usecase.GetCountriesLocalUseCaseImp
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CountriesViewModelImpTest {
    /*@ExperimentalCoroutinesApi
    @get:Rule
    var countryCoroutineRule = CountriesCoroutineRule()*/
    @RelaxedMockK
    private lateinit var getCountriesApiUseCase: GetCountriesApiUseCaseImp

    @RelaxedMockK
    private lateinit var getCountriesLocalUseCase: GetCountriesLocalUseCaseImp

    lateinit var countriesViewModelImp: CountriesViewModelImp

    @get:Rule
    val rule: InstantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        countriesViewModelImp =
            CountriesViewModelImp(getCountriesApiUseCase, getCountriesLocalUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }


    @Test
    fun `getCountriesApiUseCase get data from api is successfully`() = runTest {
        val countries: List<Countries> = listOf(
            Countries(
                nameCountry = NameCountry(nameCommon = "Barbados", nameOfficial = "Barbados"),
                capital = listOf("Bridgetown"),
                borders = null,
                flag = FlagsCountries(flagPng = "https://flagcdn.com/w320/bb.png, flagSvg=https://flagcdn.com/bb.svg"),
                independent = true,
                region = "Americas",
                area = 430.0,
                population = "287371",
                continents = listOf("North America")
            ),
            Countries(
                nameCountry = NameCountry(
                    nameCommon = "Colombia",
                    nameOfficial = "LocoLombia"
                ),
                capital = listOf("Bogota"),
                borders = null,
                flag = FlagsCountries(flagPng = "https://flagcdn.com/w320/bb.png, flagSvg=https://flagcdn.com/bb.svg"),
                independent = true,
                region = "Americas",
                area = 1231.0,
                population = "50000000",
                continents = listOf("South America")
            ),
            Countries(
                nameCountry = NameCountry(
                    nameCommon = "British Indian Ocean Territory",
                    nameOfficial = "British Indian Ocean Territory"
                ),
                capital = listOf("Diego Garcia"),
                borders = null,
                flag = FlagsCountries(flagPng = "https://flagcdn.com/w320/io.png, flagSvg=https://flagcdn.com/io.svg"),
                independent = false,
                region = "Africa",
                area = 60.0,
                population = "3000",
                continents = listOf("Asia")
            )
        )
        coEvery { getCountriesApiUseCase.invoke() } returns countries



        countriesViewModelImp.getCountriesApi()



        assert(countriesViewModelImp._countries.value == null)
    }
}