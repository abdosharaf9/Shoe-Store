package com.abdosharaf.shoestore.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abdosharaf.shoestore.models.ShoeModel

class ShoeViewModel: ViewModel() {

    // Shoe list live data which will be observed
    private val _shoesList = MutableLiveData<MutableList<ShoeModel>>()
    val shoesList: LiveData<MutableList<ShoeModel>>
        get() = _shoesList

    init {
        // Initialize the list with an empty one
        _shoesList.value = mutableListOf()
    }

    // Add the shoe to the list
    fun addShoe(name: String, company: String, size: String, description: String) {
        _shoesList.value?.add(ShoeModel(name, company, size, description))
    }

    // Clear the list
    fun removeAll() {
        _shoesList.value?.clear()
    }
}