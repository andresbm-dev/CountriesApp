package com.abm.countriesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.abm.countriesapp.databinding.ItemAdapterDetailCountryBinding


class DetailCountryAdapter(private val borders:List<String>) : RecyclerView.Adapter<DetailCountryAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemAdapterDetailCountryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(border: String) {
            binding.tvBorders.text = border
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAdapterDetailCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int =borders.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(borders[position])
    }
}