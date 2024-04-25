package com.codelab.mysoothe_health

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.mysoothe_health.ui.theme.MySootheTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SearchBar()
                }
            }
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(stringResource(R.string.search_area_placeholder))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
    )
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawableImage: Int, @StringRes imageTitle: Int,
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(drawableImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(imageTitle),
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}


@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawableImage: Int, @StringRes imageTitle: Int,
    modifier: Modifier = Modifier
){
    Surface (
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant
    ){
        Row (
            modifier = modifier.width(255.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(drawableImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.size(80.dp)
            )
            Text(
                text = stringResource(imageTitle),
                style = MaterialTheme.typography.titleMedium,
                modifier = modifier.padding(16.dp)
            )
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SearchBarPreview() {
    MySootheTheme {
        SearchBar()
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AlignYourBodyElementPreview(){
    MySootheTheme {
        AlignYourBodyElement(
            R.drawable.inversion,
            R.string.inversion_image_text
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun FavoriteCollectionCardPreview(){
    MySootheTheme {
        FavoriteCollectionCard(
            drawableImage = R.drawable.nature_meditation,
            imageTitle = R.string.fav_title
        )
    }
}

