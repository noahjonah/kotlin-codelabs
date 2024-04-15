package com.codelab.composable_quadrants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.codelab.composable_quadrants.ui.theme.ComposableQuadrantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableQuadrantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposableQuadrantsTheme {
                        Column (
                            modifier = Modifier,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ){
                            Quadrants(heading = "head 1", content = "content 1")
                            Quadrants(heading = "head 1", content = "content 1")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Quadrants(heading: String, content: String) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceEvenly
    ){

        Text(
            text = heading,
            // 50% width of row
            modifier = Modifier.fillMaxWidth(0.5f)
        )


        Text(
            text = content,
            modifier = Modifier.fillMaxWidth(0.5f)
            )

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
    )
@Composable
fun GreetingPreview() {
    ComposableQuadrantsTheme {
        Column (
            modifier = Modifier,
            verticalArrangement = Arrangement.SpaceAround
        ){
            Row (
                // 50% screen Height of a row
                modifier = Modifier.fillMaxHeight(0.5f),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Quadrants(heading = "head 1", content = "content 1")
                Quadrants(heading = "head 2", content = "content 2")
            }

            Row (
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Quadrants(heading = "head 3", content = "content 3")
                Quadrants(heading = "head 4", content = "content 4")
            }
        }

    }
}