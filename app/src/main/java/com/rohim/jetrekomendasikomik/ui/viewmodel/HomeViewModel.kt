package com.rohim.jetrekomendasikomik.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohim.jetrekomendasikomik.data.KomikRepository
import com.rohim.jetrekomendasikomik.model.Komik
import com.rohim.jetrekomendasikomik.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: KomikRepository
): ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Komik>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Komik>>>
        get() = _uiState

    fun getAllKomik() {
        viewModelScope.launch {
            repository.getAllKomik()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect {komik ->
                    _uiState.value = UiState.Success(komik)
                }
        }
    }
}