package com.codelab.mysoothe_health

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
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
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSizing = calculateWindowSizeClass(activity = this)
                    MySootheApp(windowSize = windowSizing)
                }
            }
        }
    }
}


@Composable
fun MySootheApp(windowSize: WindowSizeClass) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            MySootheAppPortrait()
        }
        WindowWidthSizeClass.Expanded -> {
            MySootheAppLandscape()
        }
    }
}


@Composable
fun MySootheAppPortrait(){
    MySootheTheme {
        Scaffold(bottomBar = {BottomNavigation()}) {
            padding -> FullHomeScreen(Modifier.padding(padding))
        }
    }
}


@Composable
fun MySootheAppLandscape(){
    Surface(color = MaterialTheme.colorScheme.background) {
        Row {
            AppNavigationRail()
            FullHomeScreen()
        }
    }
}


@Composable
fun HomeScreenSection(
    @StringRes title: Int,
    contentFunction: @Composable () -> Unit
){
    Column {
        Text(
            stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(bottom = 16.dp, top = 40.dp)
                .padding(horizontal = 16.dp)
        )
        contentFunction()
    }
}


@Composable
fun FullHomeScreen(modifier: Modifier = Modifier){
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        SearchBar()
        HomeScreenSection(R.string.align_your_body_elements){
            AlignYourBodyRow()
        }
        HomeScreenSection(R.string.favorite_collections_elements){
            FavoriteCollectionGrid()
        }
        Spacer(modifier = modifier.height(15.dp))
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
            .padding(horizontal = 16.dp)
            .heightIn(min = 56.dp),
    )
}


@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int, @StringRes text: Int,
    modifier: Modifier = Modifier
){
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.bodyMedium,
            modifier = modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}


@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier,
) {
    val alignYourBodyData = mapOf(
        R.drawable.inversion to R.string.inversion_image_text,
        R.drawable.child_yoga to R.string.yoga_health,
        R.drawable.stretching to R.string.stretching_excercise,
        R.drawable.tabata to R.string.tabata_excercise,
        R.drawable.prenatal to R.string.pre_natal_yoga,
        R.drawable.hiit to R.string.hiit_excercise
    )
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(alignYourBodyData.toList()) { (drawable, description) ->
            AlignYourBodyElement(drawable = drawable, text = description)
        }
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


@Composable
fun FavoriteCollectionGrid(modifier: Modifier = Modifier){
    val favoriteCollectionData = mapOf(
        R.drawable.nature_meditation to R.string.fav_title,
        R.drawable.overwheamed to R.string.overwhelmed_text,
        R.drawable.shortmantra to R.string.shortmantra_text,
        R.drawable.stress_anxiety to R.string.stressAnxiety_text,
        R.drawable.self_massage to R.string.selfMassage_text,
        R.drawable.night_wind to R.string.nightWind_txt
    )
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.height(200.dp)
    ){
        items(favoriteCollectionData.toList()){ (drawable, description) ->
            FavoriteCollectionCard(drawableImage = drawable, imageTitle = description)
        }
    }
}


@Composable
fun BottomNavigation(modifier: Modifier = Modifier){
    NavigationBar(
        contentColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home, contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.home_nav_text))
            },
            selected = true,
            onClick = {}
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle, contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.profile_nav_text))
            },
            selected = false,
            onClick = {}
        )
    }
}


@Composable
fun AppNavigationRail(modifier: Modifier = Modifier){
    NavigationRail(
        contentColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                selected = true,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home, contentDescription = null,
                    )
                },
                label = {
                    Text(stringResource(R.string.home_nav_text))
                },
                modifier = modifier.padding(15.dp)
            )

            NavigationRailItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle, contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(id = R.string.profile_nav_text))
                },
                modifier = modifier.padding(15.dp)
            )
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun MySootheAppPortraitPreview(){
    MySootheTheme {
        MySootheAppPortrait()
    }
}


// ALL COMPOSABLE PREVIEWS
/**

@Preview
@Composable
fun AppNavigationRailPreview(){
    MySootheTheme {
        AppNavigationRail()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun FullHomeScreenPreview(){
    MySootheTheme {
        FullHomeScreen()
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun BottomNavigationPreview(){
    MySootheTheme {
        BottomNavigation()
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
        AlignYourBodyRow()
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

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun FavoriteCollectionGridPreview(){
    MySootheTheme {
        FavoriteCollectionGrid()
    }
}

**/
