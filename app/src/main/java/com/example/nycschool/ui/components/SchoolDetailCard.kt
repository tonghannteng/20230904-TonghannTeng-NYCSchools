package com.example.nycschool.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "DBN ${schoolDetail.dbn}",
                style = MaterialTheme.typography.h4,
            )
            Text(
                text = "School Name: ${schoolDetail.school_name}",
                style = MaterialTheme.typography.subtitle1,
            )
            Text(
                text = "Test Takers: ${schoolDetail.num_of_sat_test_takers}",
                style = MaterialTheme.typography.subtitle1,
            )
            Text(
                text = "Average Score: ${schoolDetail.sat_critical_reading_avg_score}",
                style = MaterialTheme.typography.subtitle1,
            )
            Text(
                text = "Math Average Score: ${schoolDetail.sat_math_avg_score}",
                style = MaterialTheme.typography.subtitle1,
            )
            Text(
                text = "Writing Average Score: ${schoolDetail.sat_writing_avg_score}",
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}
