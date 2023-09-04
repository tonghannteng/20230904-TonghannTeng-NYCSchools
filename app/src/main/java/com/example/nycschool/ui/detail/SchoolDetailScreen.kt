package com.example.nycschool.ui.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SchoolDetailScreen(
    viewModel: SchoolDetailViewModel,
    dbn: String
) {

    Text(text = dbn)
}