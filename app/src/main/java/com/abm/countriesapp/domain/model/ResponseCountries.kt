package com.abm.countriesapp.domain.model

import com.google.gson.annotations.SerializedName

class ResponseCountries: ArrayList<Countries>()

data class Countries(
    @SerializedName("name") var nameCountry : NameCountry? = null,
    @SerializedName("capital") var capital :List<String>? = null,
    @SerializedName("borders") var borders :List<String>? = null,
    @SerializedName("flags") var flag : FlagsCountries? = null,
)

data class FlagsCountries(
    @SerializedName("png") var flagPng :String? = null,
    @SerializedName("svg") var flagSvg :String? = null
)

data class NameCountry (
    @SerializedName("common") var nameCommon : String?=null,
    @SerializedName("official") var nameOfficial : String?=null
)

