package com.example.financeapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CenterFocusStrong
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
//
////data class CardInfo(val number: String, val backgroundRes: Int)
////
////val cards = remember { mutableStateListOf<CardInfo>() }
////var showDialog by remember { mutableStateOf(false) }
////var cardNumber by remember { mutableStateOf("") }
////
////if (showDialog) {
////    AlertDialog(
////        onDismissRequest = { showDialog = false },
////        title = { Text("Add Card") },
////        text = {
////            Column {
////                OutlinedTextField(
////                    value = cardNumber,
////                    onValueChange = { cardNumber = it },
////                    label = { Text("Card Number") }
////                )
////            }
////        },
////        confirmButton = {
////            TextButton(onClick = {
////                if (cardNumber.isNotBlank()) {
////                    cards.add(CardInfo("**** ${cardNumber.takeLast(4)}", R.drawable.card_background1))
////                    cardNumber = ""
////                    showDialog = false
////                }
////            }) {
////                Text("Add")
////            }
////        },
////        dismissButton = {
////            TextButton(onClick = {
////                showDialog = false
////                cardNumber = ""
////            }) {
////                Text("Cancel")
////            }
////        }
////    )
////}
////
////Row {
////    Text("Cards", modifier = Modifier.align(Alignment.CenterVertically))
////
////    Spacer(modifier = Modifier.width(10.dp))
////
////    // Add Button Card
////    Card(
////        modifier = Modifier
////            .size(50.dp)
////            .clickable { showDialog = true },
////        shape = RoundedCornerShape(30.dp),
////        colors = CardDefaults.cardColors(containerColor = Color(0xFFb8dec7))
////    ) {
////        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
////            Icon(
////                imageVector = Icons.Default.Add,
////                contentDescription = "Add Card",
////                tint = Color.White
////            )
////        }
////    }
////
////    Spacer(modifier = Modifier.width(10.dp))
////
////    // Dynamically Render Added Cards
////    cards.forEach { card ->
////        Card(
////            modifier = Modifier
////                .height(50.dp)
////                .width(90.dp)
////                .padding(end = 8.dp),
////            shape = RoundedCornerShape(10.dp)
////        ) {
////            Box {
////                Image(
////                    painter = painterResource(card.backgroundRes),
////                    contentDescription = "Card Background",
////                    modifier = Modifier.fillMaxSize(),
////                    contentScale = ContentScale.Crop
////                )
////                Text(
////                    text = card.number,
////                    color = Color.White,
////                    modifier = Modifier
////                        .align(Alignment.BottomStart)
////                        .padding(start = 10.dp)
////                )
////            }
////        }
////    }
////}
@Composable
fun CustomBottomBar(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(80.dp).shadow(elevation = 10.dp),
                containerColor = Color(0xFFEEEEEE),
                contentColor = Color.Black,
                tonalElevation = 10.dp
            ) {
                IconButton(onClick = { navController.navigate("bar") }) {
                    Icon(Icons.Default.Home, contentDescription = "Home",
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(Modifier.weight(1f))
                IconButton(onClick = { navController.navigate("analytics") }) {
                    Icon(Icons.Default.Analytics, contentDescription = "Analytics",
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(Modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(Icons.Default.QrCodeScanner, contentDescription = "Scanner",
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(Modifier.weight(1f))
                IconButton(onClick = { navController.navigate("addCard")}) {
                    Icon(Icons.Default.CreditCard, contentDescription = "Credit Card",
                        modifier = Modifier.size(30.dp)
                    )
                }
                Spacer(Modifier.weight(1f))
                IconButton(onClick = { navController.navigate("account")}) {
                    Icon(Icons.Default.AccountCircle, contentDescription = "Account",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            HomeUI()
        }
    }
}

