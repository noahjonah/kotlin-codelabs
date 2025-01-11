package com.codelab.wellnessApp

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
){
    Column {
        StatefulCounter(modifier)

        WellnessTaskList(
            list = wellnessViewModel.tasks,
            onCheckedTask = {
              task, checked -> wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTasks = {task -> wellnessViewModel.remove(task)}
        )
    }
}
