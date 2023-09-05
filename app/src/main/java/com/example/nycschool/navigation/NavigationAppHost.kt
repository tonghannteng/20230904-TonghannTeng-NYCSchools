package com.example.nycschool.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.nycschool.ui.detail.SchoolDetailScreen
import com.example.nycschool.ui.school.SchoolScreen

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 *
 */
@Composable
fun NavigationAppHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Route.HOME
    ) {
        composable(Route.HOME) { backStackEntry ->
            SchoolScreen(
                onItemClicked = { dbn ->
                    navController.navigate("${Route.DETAIL}/$dbn")
                }
            )
        }

        composable(
            route = "${Route.DETAIL}/{${Argument.DBN_ID}}",
            arguments = listOf(
                navArgument(Argument.DBN_ID) {
                    type = NavType.StringType
                })
        ) {
            SchoolDetailScreen()
        }
    }
}

object Route {
    const val HOME = "home"
    const val DETAIL = "detail"
}

object Argument {
    const val DBN_ID = "dbnId"
}
