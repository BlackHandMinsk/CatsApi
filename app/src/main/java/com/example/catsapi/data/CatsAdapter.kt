package com.example.catsapi.data

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.catsapi.CatDiffCallback
import com.example.catsapi.databinding.CatsListItemBinding
import com.example.retrofittestapp.ApiRequest
import com.example.retrofittestapp.BASE_URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatsAdapter: ListAdapter<ApiData, CatsAdapter.MainViewHolder>(CatDiffCallback()) {

    class MainViewHolder(val binding: CatsListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(CatsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
 /// клик по айтему
//    override fun onViewAttachedToWindow(holder: MainViewHolder) {
//        holder.itemView.setOnClickListener {
//            val action  =
//                MainFragmentDirections.actionMainFragmentToUpdateFragment(currentList[holder.bindingAdapterPosition])
//            holder.itemView.findNavController().navigate(action)
//        }
//    }

    override fun onViewDetachedFromWindow(holder: MainViewHolder) {
        super.onViewDetachedFromWindow(holder)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(getItem(position).url).into(holder.binding.catImage)
    }
}