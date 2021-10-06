package com.example.catsapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.catsapi.data.CatImagesRepository

@ExperimentalPagingApi
class MainViewModel(
    val repository: CatImagesRepository = CatImagesRepository.getInstance()
) : ViewModel() {



    fun fetchCatGoImagesLiveData(): LiveData<PagingData<String>> {
        return repository.letCatGoImagesLiveData()
            .map { it.map { it.url!! } }
            .cachedIn(viewModelScope)
    }
}