package com.example.financeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Analytics
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.financeapp.CardInfo

//@Composable
//fun NavigationScreens() {
//    val navController = rememberNavController()
//
//    NavHost(
//        navController = navController,
//        startDestination = "MainScreen"
//    ) {
//        composable("seeDetails") {
//            SeeDetailsUI(navController)
//        }
//        composable("MainScreen") {
//            MainScreen(navController)
//        }
//    }
//}

@Composable
fun MainScreen() {
    val cardList = remember { mutableStateListOf<CardInfo>() }
    var selectedRoute by remember {mutableStateOf("bar")}
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.height(80.dp).shadow(elevation = 10.dp),
                containerColor = Color(0xFFEEEEEE),
                contentColor = Color.Black,
                tonalElevation = 10.dp
            ) {
                IconButton(onClick = {
                    selectedRoute = "bar"
                }) {
                    Icon(Icons.Default.Home, contentDescription = "Home",
                        modifier = Modifier.size(30.dp),
                        if (selectedRoute == "bar") Color.Black else Color.Gray
                    )
                }
                Spacer(Modifier.weight(1f))
                IconButton(onClick = {
                    selectedRoute = "analytics"
                }) {
                    Icon(Icons.Default.Analytics, contentDescription = "Analytics",
                        modifier = Modifier.size(30.dp),
                        if (selectedRoute == "analytics") Color.Black else Color.Gray
                    )
                }
                Spacer(Modifier.weight(1f))
                IconButton(onClick = {
                    selectedRoute = ""
                }) {
                    Icon(Icons.Default.QrCodeScanner, contentDescription = "Scanner",
                        modifier = Modifier.size(30.dp),
                        if (selectedRoute == "") Color.Black else Color.Gray
                    )
                }
                Spacer(Modifier.weight(1f))
                IconButton(onClick = {
                    selectedRoute = "addCard"
                }) {
                    Icon(Icons.Default.CreditCard, contentDescription = "Credit Card",
                        modifier = Modifier.size(30.dp),
                        if (selectedRoute == "addCard") Color.Black else Color.Gray
                    )
                }
                Spacer(Modifier.weight(1f))
                IconButton(onClick = {
                    selectedRoute = "account"
                }) {
                    Icon(Icons.Default.AccountCircle, contentDescription = "Account",
                        modifier = Modifier.size(30.dp),
                        if (selectedRoute == "account") Color.Black else Color.Gray
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedRoute) {
                "analytics" -> {
                    var selectedMonth by remember { mutableStateOf(MonthYear("July", 2025, dataList3, "-$2000")) }
                    AnalyticsUI(
                        selectedMonth = selectedMonth,
                        onMonthSelected = {
                            selectedMonth = it
                        }
                    )
                }
                "seeDetails" -> SeeDetailsUI()
                "addCard" -> AddCardUI(cardList)
                "account" -> ProfileUI()
                else -> HomeUI(cardList = cardList, onNavigateTo = { selectedRoute = it })
            }

        }
    }
}

