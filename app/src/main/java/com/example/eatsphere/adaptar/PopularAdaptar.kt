package com.example.eatsphere.adaptar

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eatsphere.databinding.FragmentHomeBinding
import com.example.eatsphere.databinding.PopularItemBinding

class PopularAdaptar (private val items:List<String>,private val price : List<String>,private val image: List<Int>) : RecyclerView.Adapter<PopularAdaptar.PopulerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopulerViewHolder {
        return PopulerViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }



    override fun onBindViewHolder(holder: PopulerViewHolder, position: Int) {
       val item = items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price,images)
    }

    override fun getItemCount(): Int {
       return items.size
    }
    class PopulerViewHolder (private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root){
        private val imagesView = binding.imageView6
        fun bind(item: String,price: String, images: Int) {
            binding.foodNamePopular.text=item
            binding.PricePopular.text=price
            imagesView.setImageResource(images)


        }

    }
}