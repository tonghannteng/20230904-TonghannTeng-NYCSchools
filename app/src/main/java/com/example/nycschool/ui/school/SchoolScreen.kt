package com.example.nycschool.ui.school

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
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
            ErrorScreen(schoolListResult.error)
        }
    }
}
