package com.tc.nasaapiclean.viewmodels.apod

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.data.model.data_model.Apod.ApodItemModel
import com.tc.data.model.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ApodDetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _apodData = MutableStateFlow<ApodItemModel?>(null)
    val apodData: StateFlow<ApodItemModel?> = _apodData.asStateFlow()

    // ... isLoading and errorMessage similar to ApodViewModel ...

    fun fetchApodDataForDate(date: String) {
        viewModelScope.launch {
            // ... Fetch data logic ...
            _apodData.value = repository.getApod(date)
        }
    }
}
