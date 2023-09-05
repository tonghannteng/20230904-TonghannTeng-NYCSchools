package com.example.nycschool.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nycschool.R

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 *
 */
@Composable
fun ErrorScreen(
    errorMessage: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(horizontal = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp),
                painter = painterResource(R.drawable.ic_error),
                tint = MaterialTheme.colors.primary,
                contentDescription = null
            )
            Text(
                text = errorMessage,
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}
