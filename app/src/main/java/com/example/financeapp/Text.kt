package com.example.financeapp

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CenterFocusStrong
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

//data class CardInfo(val number: String, val backgroundRes: Int)
//
//val cards = remember { mutableStateListOf<CardInfo>() }
//var showDialog by remember { mutableStateOf(false) }
//var cardNumber by remember { mutableStateOf("") }
//
//if (showDialog) {
//    AlertDialog(
//        onDismissRequest = { showDialog = false },
//        title = { Text("Add Card") },
//        text = {
//            Column {
//                OutlinedTextField(
//                    value = cardNumber,
//                    onValueChange = { cardNumber = it },
//                    label = { Text("Card Number") }
//                )
//            }
//        },
//        confirmButton = {
//            TextButton(onClick = {
//                if (cardNumber.isNotBlank()) {
//                    cards.add(CardInfo("**** ${cardNumber.takeLast(4)}", R.drawable.card_background1))
//                    cardNumber = ""
//                    showDialog = false
//                }
//            }) {
//                Text("Add")
//            }
//        },
//        dismissButton = {
//            TextButton(onClick = {
//                showDialog = false
//                cardNumber = ""
//            }) {
//                Text("Cancel")
//            }
//        }
//    )
//}
//
//Row {
//    Text("Cards", modifier = Modifier.align(Alignment.CenterVertically))
//
//    Spacer(modifier = Modifier.width(10.dp))
//
//    // Add Button Card
//    Card(
//        modifier = Modifier
//            .size(50.dp)
//            .clickable { showDialog = true },
//        shape = RoundedCornerShape(30.dp),
//        colors = CardDefaults.cardColors(containerColor = Color(0xFFb8dec7))
//    ) {
//        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
//            Icon(
//                imageVector = Icons.Default.Add,
//                contentDescription = "Add Card",
//                tint = Color.White
//            )
//        }
//    }
//
//    Spacer(modifier = Modifier.width(10.dp))
//
//    // Dynamically Render Added Cards
//    cards.forEach { card ->
//        Card(
//            modifier = Modifier
//                .height(50.dp)
//                .width(90.dp)
//                .padding(end = 8.dp),
//            shape = RoundedCornerShape(10.dp)
//        ) {
//            Box {
//                Image(
//                    painter = painterResource(card.backgroundRes),
//                    contentDescription = "Card Background",
//                    modifier = Modifier.fillMaxSize(),
//                    contentScale = ContentScale.Crop
//                )
//                Text(
//                    text = card.number,
//                    color = Color.White,
//                    modifier = Modifier
//                        .align(Alignment.BottomStart)
//                        .padding(start = 10.dp)
//                )
//            }
//        }
//    }
//}
@Composable
fun CustomBottomBar(
    navController: NavHostController,
    currentRoute: String?
) {
    val items = listOf(
        BottomNavItem("Home", Icons.Default.Home, "home"),
        BottomNavItem("Stats", Icons.Default.BarChart, "stats"),
        BottomNavItem("Scan", Icons.Default.CenterFocusStrong, "scan"), // center item
        BottomNavItem("Cards", Icons.Default.CreditCard, "cards"),
        BottomNavItem("Profile", Icons.Default.Person, "profile")
    )

    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 10.dp
    ) {
        items.forEachIndexed { index, item ->
            val selected = currentRoute == item.route

            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(if (index == 2) 56.dp else 48.dp)
                            .clip(CircleShape)
                            .background(
                                if (selected && index == 2) Color(0xFFE6F4EA) else Color.Transparent
                            )
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label,
                            tint = when {
                                selected && index == 0 -> Color(0xFF075E20) // Green for first item
                                selected -> Color(0xFF1A4D2E)
                                else -> Color.Gray
                            }
                        )
                        if (selected && index == 0) {
                            // small dot under icon
                            Box(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .size(6.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF075E20))
                                    .offset(y = 6.dp)
                            )
                        }
                    }
                },
                label = null,
                alwaysShowLabel = false
            )
        }
    }
}

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

@Composable
fun SimpleBarChart(
    data: List<Float>, // values between 0f–1f
    labels: List<String> = listOf("S", "M", "T", "W", "T", "F", "S"),
    barColor: Color = Color(0xFF81C784)
) {
    val maxBarHeight = 100.dp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        data.forEachIndexed { index, value ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                Box(
                    modifier = Modifier
                        .width(12.dp)
                        .height(maxBarHeight * value.coerceIn(0f, 1f))
                        .clip(RoundedCornerShape(4.dp))
                        .background(barColor)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = labels.getOrElse(index) { "" }, fontSize = 10.sp)
            }
        }
    }
}