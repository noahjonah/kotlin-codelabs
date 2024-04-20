package com.codelab.animatedList

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
fun OnboardScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
){
    Surface(
        modifier = modifier
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome to the basics!",
                fontSize = 20.sp
            )
            Button(
                onClick = onContinueClicked,
                modifier.padding(24.dp)
            ) {
                Text(text = "Continue")
            }
        }
    }
}

@Composable
fun MyApp(
    modifier: Modifier = Modifier
){
    val shouldShowOnBoard = remember {
        mutableStateOf(true)
    }
    
    Surface(
        modifier = modifier
    ) {
        if (shouldShowOnBoard.value){
            OnboardScreen(onContinueClicked = {shouldShowOnBoard.value = false})
        } else {
            Greetings()
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = remember{mutableStateOf(false)}
    val extraPadding = if (expanded.value) 50.dp else 0.dp
    Surface (
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth()
    ){
        Row (
            modifier = modifier.padding(24.dp)
        ){
            Column(
                modifier = modifier
                    .padding(bottom = extraPadding)
                    .weight(1f)
            ) {
                Text(text = "Hello")
                Text(text = name)
            }
            ElevatedButton(
                onClick = {
                    expanded.value = !expanded.value
                }
            ) {
                Text(
                    if (expanded.value) "Show less" else "show more"
                )
            }
        }
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
){
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        // for each word in our list we are creating a column, with 2 columns inside(from Greetings)
        Column (modifier.padding(5.dp)){
            for (name in names){
                // Greetings returns two columns -> Hello & One of the name from list
                Greeting(name = name)
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun MyAppPreview(){
    AnimatedListTheme {
        MyApp()
    }
}


/**

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    AnimatedListTheme {
        Greetings()
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun OnboardScreenPreview(){
    AnimatedListTheme {
        OnboardScreen(onContinueClicked = { /*TODO*/ })
    }
}

**/