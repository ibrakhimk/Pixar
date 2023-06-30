package com.example.pixar.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.pixar.databinding.ItemImageBinding

class AdapterImage( var list: ArrayList<SearchResult>) :
    Adapter<AdapterImage.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(
            ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    fun addImage(searchResult: ArrayList<SearchResult>)= list.addAll(searchResult)
    fun clearImage() = list.clear()

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) =holder.onBind(list[position])

    class ImageViewHolder(private val binding: ItemImageBinding) : ViewHolder(binding.root) {
        fun onBind(searchResult: SearchResult) {
            binding.imgView.load(searchResult.largeImageURL)
        }
    }
}
