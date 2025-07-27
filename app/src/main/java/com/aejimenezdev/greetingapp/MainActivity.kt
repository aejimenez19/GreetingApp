package com.aejimenezdev.greetingapp

import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aejimenezdev.greetingapp.ui.theme.GreetingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingAppTheme {
                viewMain(

                )
            }
        }
    }
}

@Preview
@Composable
fun viewMain() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        var inputText by remember { mutableStateOf("") }
        var displayedText by remember { mutableStateOf("") }

        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Enter your name") },
            placeholder = { Text("Escribe aquí...") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            singleLine = true
        )

        androidx.compose.material3.Button(
            onClick = { displayedText = inputText },
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        ) {
            Text(text = "Saludar")
        }

        if (displayedText.isNotEmpty()) {
            Greeting(
                name = "$displayedText", modifier = Modifier.padding(16.dp)
            )
        }
    }
} 

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name! welcome to my first Android App",
        modifier = modifier,
        style = MaterialTheme.typography.displayLarge,
        color = MaterialTheme.colorScheme.primary
    )
}

