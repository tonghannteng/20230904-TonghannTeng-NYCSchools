package com.example.nycschool.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.nycschool.data.model.SchoolDetail

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 *
 */
@Composable
fun SchoolDetailCard(
    schoolDetail: SchoolDetail
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = schoolDetail.dbn,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = schoolDetail.school_name,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}