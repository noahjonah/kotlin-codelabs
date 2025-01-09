package com.codelab.wellnessApp

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.codelab.wellnessApp.ui.theme.WellnessAppTheme

@Composable
fun WellnessScreen(modifier: Modifier = Modifier){
    Column {
        StatefulCounter(modifier)

        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTaskList(onCloseTasks = { task -> list.remove(task) }, list = list, modifier)
    }
}

private fun getWellnessTasks() = List(30) {
        i -> WellnessTasks(i, "Task # $i")
}
