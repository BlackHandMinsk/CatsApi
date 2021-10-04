package com.example.catsapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catsapi.data.Cat
import com.example.catsapi.data.CatsApiImpl
import kotlinx.coroutines.launch

class CatViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Cat>>()
    val items: LiveData<List<Cat>> get() = _items

    init {
        viewModelScope.launch {
            _items.value = CatsApiImpl.getListOfCat()
        }
    }
}