package com.example.nycschool.ui.school

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nycschool.data.model.School
import com.example.nycschool.ui.UiState
import com.example.nycschool.ui.components.ErrorScreen
import com.example.nycschool.ui.components.ProgressIndicator
import com.example.nycschool.ui.components.SchoolCard
import com.example.nycschool.ui.components.visible

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 *
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SchoolScreen(
    onItemClicked: (dbn: String) -> Unit
) {
    val viewModel = hiltViewModel<SchoolViewModel>()
    when (val schoolListResult = viewModel.schoolList.collectAsState().value) {

        is UiState.Loading -> {
            ProgressIndicator(modifier = Modifier.visible(true))
        }

        is UiState.Success -> {
            Scaffold(
                topBar = {
                    SchoolAppBar()
                }
            ) {
                SchoolList(
                    schoolList = schoolListResult.data,
                    onItemClicked = onItemClicked
                )
            }
        }

        is UiState.Error -> {
            ErrorScreen(schoolListResult.error)
        }
    }
}

@Composable
private fun SchoolAppBar() {
    TopAppBar(
        title = { Text(text = "Home") }
    )
}

@Composable
fun SchoolList(
    schoolList: List<School>,
    onItemClicked: (dbn: String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(schoolList.size) {
            SchoolCard(
                school = schoolList[it],
                onItemClicked
            )
        }
    }
}
