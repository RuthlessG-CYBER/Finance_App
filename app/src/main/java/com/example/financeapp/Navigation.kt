package com.example.financeapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationScreens(){
    NavHost(
        navController = rememberNavController(),
        startDestination = "home"
    ){
        composable("home"){
            HomeUI()
        }
        composable("analytics") {
            AnalyticsUI()
        }
    }
}