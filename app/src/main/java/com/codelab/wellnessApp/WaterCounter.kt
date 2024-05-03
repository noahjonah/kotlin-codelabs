package com.codelab.wellnessApp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier){
    val counter: MutableState<Int> = remember { mutableIntStateOf(0) }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        if (counter.value > 0){
            Text(
                text = "You've had ${counter.value} glasses.",
                modifier = modifier.padding(16.dp)
            )
        }

        Button(
            onClick = { counter.value++ },
            enabled = counter.value < 10,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text("Add One")
        }
    }
}