package com.rohim.jetrekomendasikomik.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object About : Screen("About")
    object DetailKomik : Screen("home/{komikId}") {
        fun createRoute(komikId: Long) = "home/$komikId"
    }
}