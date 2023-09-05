package com.example.nycschool.ui.components

import androidx.compose.foundation.clickable
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
import com.example.nycschool.data.model.School

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 *
 */
@Composable
fun SchoolCard(
    school: School,
    onItemClicked: (dbn: String) -> Unit = {}
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .clickable { onItemClicked(school.dbn) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "DBN: ${school.dbn}",
                style = MaterialTheme.typography.body1,
            )
            Text(
                text = "School Name: ${school.school_name}",
                style = MaterialTheme.typography.subtitle1,
            )
            Text(
                text = "BORO: ${school.boro}",
                style = MaterialTheme.typography.subtitle1,
            )
            Text(
                text = "Location: ${school.location}",
                style = MaterialTheme.typography.subtitle1,
            )
            Text(
                text = "Phone Number: ${school.phone_number}",
                style = MaterialTheme.typography.subtitle1,
            )
            Text(
                text = "School Email: ${school.school_email}",
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}