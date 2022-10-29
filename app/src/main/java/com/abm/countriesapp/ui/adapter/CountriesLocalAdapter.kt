package com.abm.countriesapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abm.countriesapp.ApplicationActivity
import com.abm.countriesapp.data.database.CountriesEntity
import com.abm.countriesapp.databinding.ItemAdapterLocalCountriesBinding
import com.bumptech.glide.Glide

class CountriesLocalAdapter(
    private var countries: List<CountriesEntity>
) : RecyclerView.Adapter<CountriesLocalAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemAdapterLocalCountriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(countries: CountriesEntity) {

            binding.tvNameCountry.text = countries.nameCountry
            binding.tvNameCapital.text = countries.capital

            Glide.with(ApplicationActivity.context).load(countries.imageFlag)
                .into(binding.imageCountry)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAdapterLocalCountriesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int = countries.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateCountries(countries: List<CountriesEntity>) {
        this.countries = countries
        notifyDataSetChanged()
    }
}