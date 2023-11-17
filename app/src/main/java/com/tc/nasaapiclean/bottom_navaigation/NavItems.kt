package com.tc.nasaapiclean.bottom_navaigation

import com.tc.nasaapiclean.R

data class NavItems(
    val route:String,
    val title:String,
    val icon:Int,
    val icon_fill:Int

)

val listOfNavItems:List<NavItems> = listOf(
    NavItems(
        route = Screens.ApodScreen.name,
        title = "APOD",
        icon = R.drawable.picture_of_the_day_unfill,
        icon_fill = R.drawable.picture_of_the_day_fill
    ),
    NavItems(
        route = Screens.MarRoverScreen.name,
        title = "Mar Rover",
        icon = R.drawable.rover_unfilled,
        icon_fill = R.drawable.rover_filled
    ),
    NavItems(
        route = Screens.SpaceFactScreen.name,
        title = "Space Fact",
        icon = R.drawable.quiz_unfilled,
        icon_fill = R.drawable.quiz_filled
    )
)