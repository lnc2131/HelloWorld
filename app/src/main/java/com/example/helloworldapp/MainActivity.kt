package com.example.helloworldapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.foundation.layout.width
import com.example.helloworldapp.ui.theme.HelloWorldAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HelloWorldScreen()
                }
            }
        }
    }
}

@Composable
fun HelloWorldScreen() {
    var textVisible by remember{mutableStateOf(false)}
    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {textVisible = !textVisible}) {
            Text(text = if (textVisible) "Hide Text" else "Show Text")
        }
        if (textVisible) {
            Text(
                text = "Hello World",
                modifier = Modifier.padding(top=16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWorldAppTheme {
        HelloWorldScreen()
    }
}