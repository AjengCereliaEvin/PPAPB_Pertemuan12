package com.example.tugaspertemuan12

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.example.tugaspertemuan12.databinding.ItemFictionBinding
import com.example.tugaspertemuan12.model.Data

class FictionAdapter(private val listFiction: List<Data>) :
    RecyclerView.Adapter<FictionAdapter.ItemFictionViewHolder>() {

    inner class ItemFictionViewHolder(private val binding: ItemFictionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            with(binding) {
                nameTxt.text = data.name
                speciesTxt.text = data.species
                locationTxt.text = data.location
                gender.text = data.gender

                Glide.with(itemView.context).asBitmap()
                    .load(data.image)
                    .transition(BitmapTransformation.withCrossFade())
                    .into(fictionImg)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): FictionAdapter.ItemFictionViewHolder {
        val binding =
            ItemFictionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemFictionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FictionAdapter.ItemFictionViewHolder, position: Int) {
        holder.bind(listFiction[position])
    }

    override fun getItemCount(): Int {
        return listFiction.size
    }
}
