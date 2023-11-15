package com.tc.nasaapiclean.screens.apod

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.tc.nasaapiclean.viewmodels.apod.ApodDetailViewModel

@Composable
fun ApodDetailScreen(date: String) {
    val viewModel = hiltViewModel<ApodDetailViewModel>()
    LaunchedEffect(date) {
        viewModel.fetchApodDataForDate(date)
    }

    val apodData = viewModel.apodData.collectAsState().value

    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {

        // Build your UI based on these states
        item {
            // Show APOD data
            apodData?.let { data ->

                Card (

                    modifier = Modifier.fillMaxWidth(.8f),
                    elevation = CardDefaults.cardElevation( 8.dp),
                    shape = RoundedCornerShape(8.dp),



                    ){
                    Text("Date: ${data.date}", textAlign = TextAlign.Center)
                    Text("Title: ${data.title}", textAlign = TextAlign.Center)

                    AsyncImage(
                        model = data.url,
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )

                    Text("Explanation: ${data.explanation}", textAlign = TextAlign.Center)

                }
                // Display the APOD data

            }
        }

        }

    }

