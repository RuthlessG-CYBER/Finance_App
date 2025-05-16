package com.example.financeapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun SettingsUI(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
            Text(
                text = "Settings",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Divider(color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))

            var isChecked by remember { mutableStateOf(false) }

            Row(modifier = Modifier.padding(start = 25.dp, end = 25.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Text("Dark Mode ${if (isChecked) "ON" else "OFF"}")
                Spacer(modifier = Modifier.weight(1f))
                Switch(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "App Info",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(5.dp))
            Divider(color = Color.Black,
                thickness = 1.dp,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.padding(start = 25.dp, end = 25.dp)){
                Text(
                    text = "Version 1.0.0",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(onClick = {}) {
                    Text(text = "Update")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.padding(start = 25.dp, end = 25.dp)){
                Text(
                    text = "Terms of Service",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}


