package com.codelab.composable_quadrants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                            Quadrants(
                                headingOne = stringResource(R.string.headingOne),
                                contentOne = stringResource(R.string.contentOne),

                                headingTwo = stringResource(R.string.headingTwo),
                                contentTwo = stringResource(R.string.contentTwo),

                                headingThree = stringResource(R.string.headingThree),
                                contentThree = stringResource(R.string.contentThree),

                                headingFour = stringResource(R.string.headingFour),
                                contentFour = stringResource(R.string.contentFour)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Quadrants(
    headingOne: String, contentOne: String, headingTwo: String, contentTwo: String,
    headingThree: String, contentThree: String, headingFour: String, contentFour: String
    ) {
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        ){
            Column(
                modifier = Modifier
                    .background(Color(0xFFEADDFF))
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f),

                // Center align all of the content vertically and horizontally in each quadrant
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = headingOne,
                    modifier = Modifier.padding(
                        start = 0.dp,
                        top = 0.dp,
                        end = 0.dp,
                        bottom = 16.dp
                    )
                )
                Text(
                    text = contentOne,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                )
            }
            Column (
                modifier = Modifier
                    .background(Color(0xFFD0BCFF))
                    .fillMaxHeight()
                    .fillMaxWidth(),

                // Center align all of the content vertically and horizontally in each quadrant
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = headingTwo,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = contentTwo,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                )
            }
        }
// Second row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()

        ){
            Column(
                modifier = Modifier
                    .background(Color(0xFFB69DF8))
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f),

                // Center align all of the content vertically and horizontally in each quadrant
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = headingThree,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp
                    )
                )
                Text(
                    text = contentThree,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                )
            }
            Column (
                modifier = Modifier
                    .background(Color(0xFFF6EDFF))
                    .fillMaxHeight()
                    .fillMaxWidth(),

                // Center align all of the content vertically and horizontally in each quadrant
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = headingFour,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = contentFour,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
    )
@Composable
fun GreetingPreview() {
    ComposableQuadrantsTheme {
        Quadrants(
            headingOne = stringResource(R.string.headingOne),
            contentOne = stringResource(R.string.contentOne),

            headingTwo = stringResource(R.string.headingTwo),
            contentTwo = stringResource(R.string.contentTwo),

            headingThree = stringResource(R.string.headingThree),
            contentThree = stringResource(R.string.contentThree),

            headingFour = stringResource(R.string.headingFour),
            contentFour = stringResource(R.string.contentFour)
        )
    }
}