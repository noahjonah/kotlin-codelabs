package com.codelab.wellnessApp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class WellnessTasks(
    val id: Int,
    val label: String,
    initialChecked: Boolean = false
){
    var checked by mutableStateOf(initialChecked)
}
