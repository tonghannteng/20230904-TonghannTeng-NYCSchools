package com.example.nycschool.ui.components

import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

/**
 * @author: tonghann.teng
 * @since: 9/5/2023
 *
 */
@Stable
fun Modifier.visible(visibility: Boolean): Modifier {
    return if (visibility) {
        this.then(alpha(1f))
    } else {
        this.then(alpha(0f))
    }
}
