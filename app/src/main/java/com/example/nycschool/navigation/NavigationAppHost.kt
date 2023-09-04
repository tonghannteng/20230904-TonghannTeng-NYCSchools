package com.example.nycschool.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.nycschool.ui.detail.SchoolDetailScreen
import com.example.nycschool.ui.detail.SchoolDetailViewModel
import com.example.nycschool.ui.school.SchoolScreen
import com.example.nycschool.ui.school.SchoolViewModel

@Composable
fun NavigationAppHost(
    navController: NavHostController,
    schoolViewModel: SchoolViewModel,
    schoolDetailViewModel: SchoolDetailViewModel
) {
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = Destination.Home.route
    ) {
        composable(Destination.Home.route) {
            SchoolScreen(
                viewModel = schoolViewModel,
                onItemClicked = { dbn ->
                    navController.navigate(Destination.Details.createRoute(dbnId = dbn))
                }
            )
        }
        composable(Destination.Details.route) { navBackStackEntry ->
            val dbnId = navBackStackEntry.arguments?.getString("dbnId")
            if (dbnId == null) {
                Toast.makeText(context, "dbnId is required", Toast.LENGTH_SHORT).show()
            } else {
                SchoolDetailScreen(
                    viewModel = schoolDetailViewModel,
                    dbn = dbnId
                )
            }
        }
    }
}
