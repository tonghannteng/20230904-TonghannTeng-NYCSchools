package com.example.nycschool.ui.detail

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
import com.example.nycschool.data.model.SchoolDetail
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
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SchoolDetailScreen() {
    val viewModel = hiltViewModel<SchoolDetailViewModel>()

    when (val schoolDetailResult = viewModel.schoolDetail.collectAsState().value) {

        is UiState.Loading -> {
            ProgressIndicator(modifier = Modifier.visible(true))
        }

        is UiState.Success -> {
            Scaffold(
                topBar = {
                    SchoolDetailAppBar()
                }
            ) {
                SchoolDetailList(schoolList = schoolDetailResult.data)
            }
        }

        is UiState.Error -> {
            ErrorScreen(errorMessage = schoolDetailResult.error)
        }

    }
}

@Composable
private fun SchoolDetailAppBar() {
    TopAppBar(
        title = { Text(text = "Detail") }
    )
}

@Composable
fun SchoolDetailList(schoolList: List<SchoolDetail>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(schoolList.size) {
            SchoolDetailCard(
                schoolDetail = schoolList[it]
            )
        }
    }
}
