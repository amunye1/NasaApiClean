package com.tc.nasaapiclean.viewmodels.apod

import androidx.compose.runtime.mutableStateOf
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
class ApodViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    // MutableStateFlow for internal state management
    private val _apodData = MutableStateFlow<List<ApodItemModel?>?>(null)
    private val _isLoading = MutableStateFlow(false)
    private val _errorMessage = MutableStateFlow("")

    // Publicly exposed immutable StateFlows
    val apodData: StateFlow<List<ApodItemModel?>?> = _apodData.asStateFlow()
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()
    val errorMessage: StateFlow<String> = _errorMessage.asStateFlow()

    fun fetchApod(startDate: String, endDate: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _apodData.value = repository.getApod(startDate, endDate)
                _errorMessage.value = ""
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "Error fetching data"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
