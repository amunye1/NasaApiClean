package com.tc.nasaapiclean

import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.tc.nasaapiclean.screens.apod.ApodScreen
import org.junit.Rule
import org.junit.Test

class ApodScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    @Composable
    fun apod_screen_button_text(){
        val navController = rememberNavController()
        composeTestRule.setContent {
            ApodScreen(navController = navController)
        }

        composeTestRule
            .onNodeWithText("Fetch APOD Data")
            .assertIsDisplayed()
    }

    @Test
    @Composable
    fun apod_screen_button(){
        val navController = rememberNavController()
        composeTestRule.setContent {
            ApodScreen(navController = navController)
            composeTestRule
                .onNodeWithText("Fetch APOD Data")
                .performClick()

        }
    }
}