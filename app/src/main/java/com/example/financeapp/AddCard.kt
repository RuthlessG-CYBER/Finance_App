package com.example.financeapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddCardUI(cardList: MutableList<CardInfo>) {
    var name by remember { mutableStateOf("") }
    var number by remember { mutableStateOf("") }
    var expiry by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }

    var showDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Add New Card",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Cardholder Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = number,
                onValueChange = { number = it },
                label = { Text("Card Number") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = expiry,
                    onValueChange = { expiry = it },
                    label = { Text("Expiry") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )
                OutlinedTextField(
                    value = cvv,
                    onValueChange = { cvv = it },
                    label = { Text("CVV") },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                    visualTransformation = PasswordVisualTransformation()
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    if (name.isNotBlank() && number.isNotBlank() && expiry.isNotBlank() && cvv.isNotBlank()) {
                        cardList.add(CardInfo(name, number, expiry, cvv))
                        name = ""
                        number = ""
                        expiry = ""
                        cvv = ""
                        showDialog = true
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Save Card")
            }

            Spacer(modifier = Modifier.height(20.dp))


            // It is for check the card list
//            Text("Saved Cards:", fontWeight = FontWeight.Bold, fontSize = 18.sp)
//            cardList.forEach { card ->
//                Text("Name: ${card.name}, Number: ${card.number}, Expiry: ${card.expiry}, CVV: ${card.cvv}")
//                Spacer(modifier = Modifier.height(8.dp))
//            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Card Saved") },
                    text = { Text("Your card has been saved successfully.") },
                    confirmButton = {
                        TextButton(onClick = { showDialog = false }) {
                            Text("OK")
                        }
                    }
                )
            }
        }
    }
}
