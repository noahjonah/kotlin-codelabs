package com.codelab.wellnessApp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.codelab.wellnessApp.ui.theme.WellnessAppTheme

@Composable
fun StatelessWellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose:() -> Unit,
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier.fillMaxSize()
    ){
        Text(text = taskName, modifier = Modifier.weight(1f))
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Closing Button")
        }
    }
}

@Composable
fun StatefulWellnessTaskItem(taskName: String, onClose: () -> Unit, modifier: Modifier = Modifier){
    var checkedState by rememberSaveable { mutableStateOf(false) };

    StatelessWellnessTaskItem(
        taskName = taskName,
        checked = checkedState,
        onCheckedChange = { changedValue -> checkedState = changedValue },
        onClose = onClose,
        modifier =modifier
    )
}

