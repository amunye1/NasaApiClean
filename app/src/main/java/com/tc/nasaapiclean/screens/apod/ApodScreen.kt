package com.tc.nasaapiclean.screens.apod

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.tc.nasaapiclean.viewmodels.apod.ApodViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ApodScreen(navController: NavController) {
    val viewModel = hiltViewModel<ApodViewModel>()
    // Collect StateFlow values as state
    val apodData = viewModel.apodData.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value
    val errorMessage = viewModel.errorMessage.collectAsState().value

    val selectedDate = remember { mutableStateOf(generateRandomPastDate()) }
    LaunchedEffect(Unit) {
        viewModel.fetchApod(selectedDate.value)
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { viewModel.fetchApod(selectedDate.value) }) {
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

                Card (

                    modifier = Modifier.fillMaxWidth(.8f)
                        .clickable {
                        navController.navigate("apodDetail/${selectedDate.value}")
                    },
                    elevation = CardDefaults.cardElevation( 8.dp),
                    shape = RoundedCornerShape(8.dp),



                ){
                    Text("Title: ${data.title}", textAlign = TextAlign.Center)
                    Box(modifier = Modifier.fillMaxSize()) {
                        AsyncImage(
                            model = data.url,
                            contentDescription = null,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                }
                // Display the APOD data

            }
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun generateRandomPastDate(): String {
    val maxDaysInPast = 1825 // Approx 5 years
    val randomDaysInPast = Random.nextInt(maxDaysInPast)

    val randomPastDate = LocalDate.now().minusDays(randomDaysInPast.toLong())
    return randomPastDate.format(DateTimeFormatter.ISO_LOCAL_DATE)
}


