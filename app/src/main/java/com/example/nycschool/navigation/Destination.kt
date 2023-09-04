package com.example.nycschool.navigation

sealed class Destination(val route: String) {
    data object Home : Destination("home")
    data object Details : Destination("details/{dbnId}") {
        fun createRoute(dbnId: String) = "details/$dbnId"
    }
}
