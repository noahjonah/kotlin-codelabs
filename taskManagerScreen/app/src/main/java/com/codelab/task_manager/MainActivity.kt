package com.codelab.task_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codelab.task_manager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskManager(
                        stringResource(R.string.work_status),
                        stringResource(R.string.work_applauses)
                    )
                }
            }
        }
    }
}


@Composable
fun TaskManager(message: String, applause: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column (
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            val taskImage = painterResource(id = R.drawable.ic_task_completed)

            Image(
                painter = taskImage,
                contentDescription = "Task complete status image",
                contentScale = ContentScale.Crop
            )

            Text(
                text = message,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier.padding(24.dp, 8.dp)
            )

            Text(
                text = applause,
                fontSize = 16.sp
            )
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
    )
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        TaskManager(
            stringResource(R.string.work_status),
            stringResource(R.string.work_applauses)
        )
    }
}