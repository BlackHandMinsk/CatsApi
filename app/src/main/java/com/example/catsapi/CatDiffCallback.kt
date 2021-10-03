package com.example.catsapi

import androidx.recyclerview.widget.DiffUtil
import com.example.catsapi.data.ApiData

class CatDiffCallback: DiffUtil.ItemCallback<ApiData>() {
    override fun areItemsTheSame(
        oldItem: ApiData,
        newItem: ApiData
    ): Boolean =oldItem.id==newItem.id

    override fun areContentsTheSame(
        oldItem: ApiData,
        newItem: ApiData
    ): Boolean = oldItem==newItem
}