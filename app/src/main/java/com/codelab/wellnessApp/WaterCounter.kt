package com.codelab.wellnessApp

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier){
    val counter = 0
    Text(
        text = "You've had $counter glasses.",
        modifier = modifier.padding(16.dp)
    )
}