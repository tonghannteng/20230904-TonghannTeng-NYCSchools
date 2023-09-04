package com.example.nycschool.ui.school

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.nycschool.ui.UiState
import com.example.nycschool.ui.components.SchoolCard

@Composable
fun SchoolScreen(
    viewModel: SchoolViewModel,
    onItemClicked: (dbn: String) -> Unit
) {

    when (val schoolListResult = viewModel.schoolList.collectAsState().value) {

        is UiState.Loading -> {

        }

        is UiState.Success -> {
            LazyColumn {
                val schoolList = schoolListResult.data
                items(schoolList.size) {
                    SchoolCard(
                        school = schoolList[it],
                        onItemClicked
                    )
                }
            }
        }

        is UiState.Error -> {

        }
    }
}
