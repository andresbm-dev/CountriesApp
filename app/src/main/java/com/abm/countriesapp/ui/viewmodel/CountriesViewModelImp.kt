package com.abm.countriesapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abm.countriesapp.data.database.CountriesEntity
import com.abm.countriesapp.domain.model.Countries
import com.abm.countriesapp.domain.usecase.GetCountriesApiUseCase
import com.abm.countriesapp.domain.usecase.GetCountriesLocalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CountriesViewModelImp @Inject constructor(
    private val getCountriesApiUseCase: GetCountriesApiUseCase,
    private val getCountriesLocalUseCase: GetCountriesLocalUseCase
) : ViewModel(), CountriesViewModel {

    var _countries: MutableLiveData<List<Countries>> = MutableLiveData()
    val countries: LiveData<List<Countries>> get()  = _countries

    private val _paramCountry: MutableLiveData<Countries> = MutableLiveData()
    val paramCountry: LiveData<Countries> = _paramCountry

    private val _countriesDataBase: MutableLiveData<List<CountriesEntity>> = MutableLiveData()
    val countriesDataBase: LiveData<List<CountriesEntity>> = _countriesDataBase

    private val _progressBar : MutableLiveData<Boolean> = MutableLiveData()
    val progressBar :LiveData<Boolean> = _progressBar

    override fun getCountriesApi() {
        viewModelScope.launch {
            _progressBar.postValue(true)
            withContext(Dispatchers.IO) {
                _countries.postValue(getCountriesApiUseCase.invoke())
            }
            _progressBar.postValue(false)
        }
    }

    override fun getCountriesLocal() {
        viewModelScope.launch {
            _progressBar.postValue(true)
            withContext(Dispatchers.IO) {
                val countriesLocal = getCountriesLocalUseCase.invoke()
                _countriesDataBase.postValue(countriesLocal)
            }
            _progressBar.postValue(false)
        }
    }

    fun sendParams(countries: Countries) {
        _paramCountry.postValue(countries)
    }
}