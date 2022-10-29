package com.abm.countriesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abm.countriesapp.ApplicationActivity.Companion.context
import com.abm.countriesapp.databinding.ItemAdapterCountriesBinding
import com.abm.countriesapp.domain.model.Countries
import com.bumptech.glide.Glide

class CountriesAdapter(
    private var countries: List<Countries>,
    private val callbackDetail:(Countries)->Unit

    ):RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemAdapterCountriesBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(countries: Countries, callbackDetail: (Countries) -> Unit) {

            binding.tvNameCountry.text = countries.nameCountry?.nameOfficial
            countries.capital?.forEach{
                binding.tvNameCapital.text = it
            }
            Glide.with(context).load(countries.flag?.flagPng).into(binding.imageCountry)
            binding.containerCard.setOnClickListener {
                callbackDetail(countries)
            }
            binding.imageCountry.setOnClickListener {
                callbackDetail(countries)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAdapterCountriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(countries[position], callbackDetail)
    }

    override fun getItemCount(): Int =countries.size
    fun updateCountries(countries : List<Countries>){
        this.countries = countries
        notifyDataSetChanged()
    }
}