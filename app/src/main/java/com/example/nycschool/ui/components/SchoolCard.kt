package com.example.nycschool.ui.components

import androidx.compose.foundation.clickable
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
import com.example.nycschool.data.model.School

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
                text = school.school_name,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}