package com.example.catsapi.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.bumptech.glide.Glide
import com.example.catsapi.R
import com.example.catsapi.model.CatImageModel
import com.example.catsapi.ui.MainFragmentDirections

class CatsAdapter : PagingDataAdapter<String, RecyclerView.ViewHolder>(REPO_COMPARATOR) {


    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
                oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? CatsViewHolder)?.bind(item = getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CatsViewHolder.getInstance(parent)
    }





    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        holder.itemView.setOnClickListener {
            val action  =
                MainFragmentDirections.actionMainFragmentToCatInfoFragment(getItem(holder.bindingAdapterPosition).toString())
            holder.itemView.findNavController().navigate(action)
        }
    }



    class CatsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        companion object {
            fun getInstance(parent: ViewGroup): CatsViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val view = inflater.inflate(R.layout.cats_list_item, parent, false)
                return CatsViewHolder(view)
            }
        }


        var ivCatMain: ImageView = view.findViewById(R.id.cat_image)

        fun bind(item: String?) {
            Glide.with(ivCatMain.context).load(item).into(ivCatMain)
        }

    }
}