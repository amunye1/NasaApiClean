package com.tc.nasaapiclean.screens.mars

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
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

                LazyColumn (horizontalAlignment = Alignment.CenterHorizontally){
                    items(it) {photo->
                        Box(modifier = Modifier.fillMaxSize()){
                            Card(modifier = Modifier.fillMaxSize(.8f).align(Alignment.Center),
                                shape = RoundedCornerShape(8.dp),
                                elevation = CardDefaults.elevatedCardElevation(8.dp),

                                ) {
                                Text(text ="Name: ${photo.rover?.name} \n Earth Date: ${photo.earthDate}" , textAlign = TextAlign.Center)
                                Spacer(modifier = Modifier.padding(16.dp))
                                AsyncImage(model = photo.imgSrc, contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(200.dp), // Set a fixed height or adjust as needed
                                    contentScale = ContentScale.Crop, // Adjust the scaling as needed)

                                )

                            }
                        }

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

