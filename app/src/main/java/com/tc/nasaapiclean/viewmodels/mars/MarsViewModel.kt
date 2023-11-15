package com.tc.nasaapiclean.viewmodels.mars

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tc.data.model.data_model.mars_rover.MarsRoverItemModel
import com.tc.data.model.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MarsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _marsData = MutableStateFlow<MarsRoverItemModel?>(null)
    val marsData: StateFlow<MarsRoverItemModel?> = _marsData.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: StateFlow<String> = _errorMessage.asStateFlow()

    init {
        fetchMarsData()
    }

     fun fetchMarsData() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _marsData.value = repository.getMarsPhoto() // Assuming this method exists
                _errorMessage.value = ""
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "Error fetching Mars data"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
