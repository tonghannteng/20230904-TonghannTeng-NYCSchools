package com.example.nycschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.nycschool.navigation.NavigationAppHost
import com.example.nycschool.ui.detail.SchoolDetailViewModel
import com.example.nycschool.ui.school.SchoolViewModel
import com.example.nycschool.ui.theme.NYCSchoolTheme
import dagger.hilt.android.AndroidEntryPoint

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
    val schoolViewModel: SchoolViewModel = hiltViewModel()
    val schoolDetailViewModel: SchoolDetailViewModel = hiltViewModel()

    NavigationAppHost(
        navController = navController,
        schoolViewModel = schoolViewModel,
        schoolDetailViewModel = schoolDetailViewModel
    )

}
