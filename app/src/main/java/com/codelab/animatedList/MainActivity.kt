package com.codelab.animatedList

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.animatedList.ui.theme.AnimatedListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
){
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        // for each word in our list we are creating a column, with 2 columns inside(from Greetings)
        Column (modifier){
            for (name in names){
                // Greetings returns two columns -> Hello & One of the name from list
                Greeting(name = name)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface (
        color = MaterialTheme.colorScheme.primary
    ){
        Column(
            modifier = modifier.padding(25.dp)
        ) {
            Text(text = "Hello")
            Text(text = name)
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    AnimatedListTheme {
        MyApp()
    }
}