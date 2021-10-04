package com.example.catsapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.bumptech.glide.Glide
import com.example.catsapi.CatDiffCallback
import com.example.catsapi.R
import com.example.catsapi.data.Cat
import com.example.catsapi.databinding.CatsListItemBinding
import kotlinx.coroutines.withContext

class CatsAdapter : RecyclerView.Adapter<CatsViewHolder>() {

    private val items = mutableListOf<Cat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cats_list_item, null)
        return CatsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        val fileName = items[position].id ?: ""
        val imageUrl = items[position].url?:" "
        holder.bind(fileName, imageUrl)
    }

    fun addItems(newItems: List<Cat>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}

class CatsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textView = view.findViewById<TextView>(R.id.cat_id)
    private val imageView = view.findViewById<ImageView>(R.id.cat_image)

    fun bind(filmName: String, imageUrl: String) {
        textView.text = filmName
        Glide.with(itemView.context).load(imageUrl).override(200,200).into(imageView);
        //imageView.load(imageUrl)
    }
}