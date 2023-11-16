package com.tc.nasaapiclean.screens

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tc.nasaapiclean.R
import com.tc.nasaapiclean.screens.apod.ApodDetailScreen
import com.tc.nasaapiclean.screens.apod.ApodScreen
import com.tc.nasaapiclean.screens.mars.MarsScreen
import com.tc.nasaapiclean.screens.spacefacts.SpaceFactScreen
import com.tc.nasaapiclean.ui.theme.NasaApiCleanTheme
import com.tc.nasaapiclean.viewmodels.apod.ApodViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NasaApiCleanTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Navigation Host
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "spaceFactScreen") {
                        composable("apodScreen") { ApodScreen(navController) }
                        composable(
                            "apodDetail/{date}",
                            arguments = listOf(navArgument("date") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val date = backStackEntry.arguments?.getString("date") ?: ""
                            ApodDetailScreen(date = date)
                        }
                        composable("marsScreen") { MarsScreen() }
                        composable(
                            "marsDetail/{photoId}",
                            arguments = listOf(navArgument("photoId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val photoId = backStackEntry.arguments?.getInt("photoId") ?: -1
                            //MarsDetailScreen(photoId = photoId)
                        }
                        composable("spaceFactScreen"){ SpaceFactScreen()}
                    }
                }
            }
        }
    }
}
