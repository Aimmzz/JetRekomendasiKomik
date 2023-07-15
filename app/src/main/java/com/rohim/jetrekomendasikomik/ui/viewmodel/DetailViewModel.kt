package com.rohim.jetrekomendasikomik.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohim.jetrekomendasikomik.data.KomikRepository
import com.rohim.jetrekomendasikomik.model.Komik
import com.rohim.jetrekomendasikomik.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: KomikRepository
): ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Komik>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Komik>>
        get() = _uiState

    fun getKomikById(komikId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getKomikById(komikId))
        }
    }
}