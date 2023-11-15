package com.tc.nasaapiclean.screens.apod

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tc.nasaapiclean.viewmodels.apod.ApodViewModel

@Composable
fun ApodScreen() {
    val viewModel = hiltViewModel<ApodViewModel>()
    // Collect StateFlow values as state
    val apodData = viewModel.apodData.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value
    val errorMessage = viewModel.errorMessage.collectAsState().value

    Column {
        Button(onClick = { viewModel.fetchApod("2023-01-01", "2023-01-10") }) {
            Text("Fetch APOD Data")
        }
        // Build your UI based on these states
        if (isLoading) {
            // Show loading indicator
            CircularProgressIndicator()
        } else if (!errorMessage.isEmpty()) {
            // Show error message
            Text("Error: $errorMessage")
        } else {
            // Show APOD data
            apodData?.let { data ->
                // Display the APOD data
                Text("Title: ${apodData[6]?.title}")
            }
        }
        Text("This is sample text", fontSize = 24.sp)
    }
}


