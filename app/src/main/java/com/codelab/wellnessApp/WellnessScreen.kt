package com.codelab.wellnessApp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.codelab.wellnessApp.ui.theme.WellnessAppTheme

@Composable
fun WellnessScreen(modifier: Modifier = Modifier){
    WaterCounter(modifier)
}
