package com.tc.nasaapiclean.screens.spacefacts

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.tc.nasaapiclean.R
import com.tc.nasaapiclean.viewmodels.apod.ApodViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SpaceFactScreen(){
    val viewModel = hiltViewModel<ApodViewModel>()
    // Collect StateFlow values as state
    val spaceData = viewModel.apodData.collectAsState().value
    val selectedDate = remember { mutableStateOf(generateRandomPastDate()) }
    LaunchedEffect(Unit) {
        viewModel.fetchApod(selectedDate.value)
    }
    Image(painterResource(id = R.drawable.space_theme), contentDescription = null,
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.Black,
            )
    )


        Column (horizontalAlignment = Alignment.CenterHorizontally){

            AsyncImage(model = spaceData?.url, contentDescription = null)
            Button(onClick = {
                selectedDate.value = generateRandomPastDate()
                viewModel.fetchApod(selectedDate.value)}
            ) {
                spaceData?.title?.let { Text(text = it, color = Color.White) }

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