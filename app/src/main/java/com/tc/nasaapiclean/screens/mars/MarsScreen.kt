package com.tc.nasaapiclean.screens.mars

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tc.nasaapiclean.viewmodels.mars.MarsViewModel

@Composable
fun MarsScreen() {
    val viewModel = hiltViewModel<MarsViewModel>()
    val marsData = viewModel.marsData.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value
    val errorMessage = viewModel.errorMessage.collectAsState().value

    Column {
        Button(onClick = { viewModel.fetchMarsData() }) {
            Text("Fetch Mars Rover Data")
        }

        if (isLoading) {
            CircularProgressIndicator()
        } else if (!errorMessage.isEmpty()) {
            Text("Error: $errorMessage")
        } else {
            marsData?.photos?.let {

                LazyColumn {
                    items(it) {photo->
//                    it.camera
//                    marsData?.photos?.forEach { photo ->
//                        Text(text = "Photos: ${photo}")
//                        Spacer(modifier = Modifier.padding(24.dp))
//                    }
//                    Text(text = "Photos: ${marsData?.photos}")
//                    Spacer(modifier = Modifier.padding(24.dp))
//                    Text(text = "Photos2: ${marsData?.photos?.get(1)}")
//                    Spacer(modifier = Modifier.padding(24.dp))
//                    Text(text = "Sol: ${marsData?.photos?.get(0)?.sol} " +
//                            "\n ${marsData?.photos?.get(1)} \n ${marsData?.photos?.get(2)} ")


                        //Display Mars Rover data
//                            marsData?.photos?.forEach { photo ->
//                                Text("Earth Date: ${photo.earthDate  ?: "Unknown"} \n Rover:${photo.rover ?: "Unkown"}")
//                                // Display other properties of PhotoModel here
//                            }
                    }



//
                }
            }

        }
    }
}

