package com.example.financeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationScreens() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "bar"
    ) {
        composable("bar") {
            CustomBottomBar(navController = navController)
        }
        composable("analytics") {
            var selectedMonth by remember { mutableStateOf(MonthYear("July", 2025, dataList3, "-$2000")) }
            AnalyticsUI(
                navController = navController,
                selectedMonth = selectedMonth,
                onMonthSelected = {
                    selectedMonth = it
                }
            )
        }
        composable("profile") {
            ProfileUI(navController = navController)
        }
        composable("settings") {
            SettingsUI(navController = navController)
        }
        composable("addCard") {
            AddCardUI(navController = navController)
        }
    }
}