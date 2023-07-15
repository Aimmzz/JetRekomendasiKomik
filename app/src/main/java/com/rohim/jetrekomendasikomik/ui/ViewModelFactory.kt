package com.rohim.jetrekomendasikomik.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rohim.jetrekomendasikomik.data.KomikRepository
import com.rohim.jetrekomendasikomik.ui.viewmodel.DetailViewModel
import com.rohim.jetrekomendasikomik.ui.viewmodel.HomeViewModel

class ViewModelFactory(private val repository: KomikRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}