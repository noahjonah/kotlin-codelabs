package com.codelab.animatedList

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.coerceAtLeast
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
fun OnboardScreen(onContinueClicked: () -> Unit, modifier: Modifier = Modifier){
    Surface(modifier = modifier) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome to the basics!",
                fontSize = 20.sp
            )
            // Value of onClick will be set to onContinueClicked value from another composable
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
fun MyApp(modifier: Modifier = Modifier){
    val shouldShowOnBoard = rememberSaveable { mutableStateOf(true) }
    Surface(
        modifier = modifier
    ) {
        // calling OnboardScreen OR Greetings composable upon state change(OnClick)
        if (shouldShowOnBoard.value){
            OnboardScreen(onContinueClicked = {shouldShowOnBoard.value = false})
        } else {
            Greetings()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val expanded = rememberSaveable {mutableStateOf(false)}
    val extraPadding by animateDpAsState(
        if (expanded.value) 50.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "Make the colum movements upon expanding"
    )
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
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp)) // expand to 50dp if true(Clicked)
                    .weight(1f)
            ) {
                Text(text = "Hello")
                Text(text = name)
            }

          IconButton(
              onClick = {
                  expanded.value = !expanded.value // change expand value upon click
              }
          ) {
                Icon(
                    imageVector = if (expanded.value)
                        Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = if (expanded.value) "show more" else "show less"

                )
          }
        }
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(500) {"$it"}
){
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(modifier.padding(5.dp)){
            items(items = names) {
                name -> Greeting(name = name)
            }
        }
    }
}

/**
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

**/


@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
fun GreetingPreview() {
    AnimatedListTheme {
        Greetings()
    }
}




@Preview(
    showSystemUi = true,
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
)
@Composable
fun OnboardScreenPreview(){
    AnimatedListTheme {
        OnboardScreen(onContinueClicked = { /*TODO*/ })
    }
}

