package com.codelab.bussinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codelab.bussinesscard.ui.theme.BussinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BussinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        fullName = stringResource(R.string.fullName),
                        title = stringResource(R.string.title),
                        phone = stringResource(R.string.phone),
                        social = stringResource(R.string.socialMedia),
                        email = stringResource(R.string.email)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(fullName: String, title: String, phone: String, social:String,
                 email: String, modifier: Modifier = Modifier) {
    val businessIcon = Icons.Filled.AccountCircle
    
    // First box
    Box (
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column (
            modifier = modifier.fillMaxWidth(0.85f),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Row (
                modifier = modifier
                  .fillMaxWidth(0.85f),
                horizontalArrangement = Arrangement.Center
            ){
                Icon(
                    businessIcon,
                    contentDescription = "Contact Icon",
                    modifier = modifier.size(100.dp)
                )
            }

            Row (
                modifier = modifier
                  .fillMaxWidth(0.85f),
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = fullName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            Row (
              modifier = modifier
                  .fillMaxWidth(0.85f),
              horizontalArrangement = Arrangement.Center
            ){
                Text(
                  text = title,
                  fontWeight = FontWeight.Bold,
                  fontSize = 15.sp
                )
            }
        }
    }

    //Second Box
    Box (
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 20.dp),
        contentAlignment = Alignment.BottomCenter
    ){
        Column (
            modifier = modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center
        ){
            Row (
                modifier = modifier.padding(start = 8.dp,end = 8.dp)
            ){
                Icon(
                    businessIcon,
                    contentDescription = "Contact Icon ",
                    modifier = modifier.size(30.dp),
                )
                Text(
                    text = phone,
                    color = Color.Red,
                    modifier = modifier.padding(5.dp)
                )
            }

            Row (
                modifier = modifier.padding(start = 8.dp,end = 8.dp)
            ){
                Icon(
                    businessIcon,
                    contentDescription = "Contact Icon ",
                    modifier = modifier.size(30.dp)
                )
                Text(
                    text = social,
                    color = Color(0xFF3ddc84),
                    modifier = modifier.padding(5.dp)
                )
            }

            Row (
                modifier = modifier.padding(start = 8.dp,end = 8.dp)
            ){
                Icon(
                    businessIcon,
                    contentDescription = "Contact Icon ",
                    modifier = modifier.size(30.dp)
                )
                Text(
                    text = email,
                    color = Color.Blue,
                    modifier = modifier.padding(5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BussinessCardTheme {
        BusinessCard(
            fullName = stringResource(R.string.fullName),
            title = stringResource(R.string.title),
            phone = stringResource(R.string.phone),
            social = stringResource(R.string.socialMedia),
            email = stringResource(R.string.email)
        )
    }
}