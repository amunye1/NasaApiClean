package com.tc.nasaapiclean.bottom_navaigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.tc.nasaapiclean.screens.apod.ApodScreen
import com.tc.nasaapiclean.screens.mars.MarsScreen
import com.tc.nasaapiclean.screens.spacefacts.SpaceFactScreen
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigation(navController: NavHostController){
    NavHost(
        navController,

        startDestination = Screens.ApodScreen.name,

    ) {
        composable(Screens.ApodScreen.name) { ApodScreen(navController) }
//            composable(
//                "apodDetail/{date}",
//                arguments = listOf(navArgument("date") { type = NavType.StringType })
//            ) { backStackEntry ->
//                val date = backStackEntry.arguments?.getString("date") ?: ""
//                ApodDetailScreen(date = date)
//            }
        composable(Screens.MarRoverScreen.name) { MarsScreen() }

        composable(Screens.SpaceFactScreen.name){ SpaceFactScreen() }
    }
}


