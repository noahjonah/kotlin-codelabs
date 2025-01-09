package com.codelab.wellnessApp

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTaskList(
    onCloseTasks: (WellnessTasks) -> Unit,
    list: List<WellnessTasks>,
    modifier: Modifier = Modifier
){
    LazyColumn (
        modifier = modifier
    ){
        items (
            items = list,
            key = { task = task.id }
        ) { task ->
            StatefulWellnessTaskItem(taskName = task.label, onClose = { onCloseTasks(task) }, modifier = modifier)
        }
    }
}
