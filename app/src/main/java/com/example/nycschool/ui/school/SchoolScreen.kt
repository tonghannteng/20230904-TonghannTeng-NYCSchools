package com.example.nycschool.ui.school

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nycschool.ui.UiState
import com.example.nycschool.ui.components.SchoolCard

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 *
 */
@Composable
fun SchoolScreen(
    onItemClicked: (dbn: String) -> Unit
) {
    val viewModel = hiltViewModel<SchoolViewModel>()
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
