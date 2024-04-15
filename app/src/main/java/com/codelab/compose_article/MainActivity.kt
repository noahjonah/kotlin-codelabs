package com.codelab.compose_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codelab.compose_article.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        ArticleImage()
                        ArticleContents(
                            stringResource(R.string.compose_title),
                            stringResource(R.string.compose_introduction),
                            stringResource(R.string.compose_body)
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun ArticleImage(){
    val image = painterResource(id = R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = "Just a background",
        contentScale = ContentScale.FillWidth
    )
}


@Composable
fun ArticleContents(
    title: String,
    introduction: String,
    mainBody: String
){
    Column(
        modifier = Modifier
    ){
        Text(
            text = title,
            fontSize = 24.sp,
            style = TextStyle(color = Color.Blue),
            modifier = Modifier
                .padding(16.dp)
        )

        Text(
            text = introduction,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )

        Text(
            text = mainBody,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}



@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        Column {
            ArticleImage()
            ArticleContents(
                stringResource(R.string.compose_title),
                stringResource(R.string.compose_introduction),
                stringResource(R.string.compose_body)
            )
        }
    }
}