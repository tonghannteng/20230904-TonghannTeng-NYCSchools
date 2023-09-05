package com.example.nycschool.ui.detail

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nycschool.ui.UiState
import com.example.nycschool.ui.components.ErrorScreen
import com.example.nycschool.ui.components.ProgressIndicator
import com.example.nycschool.ui.components.SchoolDetailCard
import com.example.nycschool.ui.components.visible

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 *
 */
@Composable
fun SchoolDetailScreen() {
    val viewModel = hiltViewModel<SchoolDetailViewModel>()

    when (val schoolDetailResult = viewModel.schoolDetail.collectAsState().value) {

        is UiState.Loading -> {
            ProgressIndicator(modifier = Modifier.visible(true))
        }
        is UiState.Success -> {
            LazyColumn {
                val schoolDetail = schoolDetailResult.data
                items(schoolDetail.size) {
                    SchoolDetailCard(
                        schoolDetail = schoolDetail[it]
                    )
                }
            }
        }

        is UiState.Error -> {
            ErrorScreen(errorMessage = schoolDetailResult.error)
        }

    }
}
