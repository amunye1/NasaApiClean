package com.tc.nasaapiclean
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.tc.nasaapiclean.screens.MainActivity
import org.junit.Rule
import org.junit.Test

class ApodScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun apodScreen_contentDisplayed() {
        composeTestRule.onNodeWithText("Fetch APOD Data").assertIsDisplayed()
    }

    @Test
    fun apodScreen_contentButtonClick(){
        composeTestRule.onNodeWithText("Fetch APOD Data").performClick()
    }
}