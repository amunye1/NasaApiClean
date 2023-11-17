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
import com.tc.nasaapiclean.bottom_navaigation.Screens
import com.tc.nasaapiclean.bottom_navaigation.listOfNavItems
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
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var selectedItemIndex by rememberSaveable {
                        mutableStateOf(0)
                    }
                    // Navigation Host
                    Scaffold(
                        bottomBar = {
                            NavigationBar {
                                listOfNavItems.forEachIndexed{ index, item->
                                    NavigationBarItem(
                                        selected = selectedItemIndex == index,
                                        onClick = { 
                                                  selectedItemIndex = index
                                            navController.navigate(item.route) {
                                                // Configure the navigation action to avoid unexpected behaviors
                                                launchSingleTop = true  // Avoid multiple copies of the same destination
                                                restoreState = true  // Restore state when navigating back to a screen
                                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                            }
                                                
                                        },
                                        label = {
                                                Text(text = item.title)
                                        }
                                        ,
                                        icon = { Icon(painter = painterResource(id = if(index == selectedItemIndex){
                                            
                                            item.icon_fill
                                        }else item.icon), contentDescription = item.title ) })
                                    
                                }
                            }
                        }
                    ) {it
                        NavHost(
                            navController,

                            startDestination = Screens.ApodScreen.name,

                            ) {
                            composable(Screens.ApodScreen.name) { ApodScreen(navController) }
            composable(
                "apodDetail/{date}",
                arguments = listOf(navArgument("date") { type = NavType.StringType })
            ) { backStackEntry ->
                val date = backStackEntry.arguments?.getString("date") ?: ""
                ApodDetailScreen(date = date)
            }
                            composable(Screens.MarRoverScreen.name) { MarsScreen() }

                            composable(Screens.SpaceFactScreen.name){ SpaceFactScreen() }
                        }
                    }
                }
            }
        }
    }
}
