package com.example.nycschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.nycschool.navigation.NavigationAppHost
import com.example.nycschool.ui.theme.NYCSchoolTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 *
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NYCSchoolTheme {
                NYCSchoolApp()
            }
        }
    }
}

@Composable
private fun NYCSchoolApp() {
    val navController = rememberNavController()
    NavigationAppHost(
        navController = navController
    )
}
