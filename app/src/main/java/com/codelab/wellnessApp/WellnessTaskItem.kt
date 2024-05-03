package com.codelab.wellnessApp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTaskItem(taskName: String, onClose:() -> Unit, modifier: Modifier = Modifier){
    Row (
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = taskName, modifier = Modifier.weight(1f))
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Closing Button")
        }
    }
}