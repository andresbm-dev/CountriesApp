package com.abm.countriesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abm.countriesapp.ApplicationActivity.Companion.context
import com.abm.countriesapp.databinding.ItemAdapterCountriesBinding
import com.abm.countriesapp.domain.model.Countries
import com.bumptech.glide.Glide

class CountriesAdapter(private val countries: List<Countries>):RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemAdapterCountriesBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(countries: Countries) {

            binding.tvNameCountry.text = countries.nameCountry?.nameOfficial
            val capital = countries.capital?.forEach {it[0]}
            binding.tvNameCapital.text = capital.toString()
            Glide.with(context).load(countries.flag?.flagPng).into(binding.imageCountry)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAdapterCountriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int =countries.size
}