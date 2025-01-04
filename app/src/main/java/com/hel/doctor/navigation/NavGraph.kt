package com.hel.doctor.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hel.doctor.screens.EmailScreen
import com.hel.doctor.screens.HomeScreen
import com.hel.doctor.screens.SignInScreen
import com.hel.doctor.screens.SignUpScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("signIn") { SignInScreen(navController) }
        composable("signUp") { SignUpScreen(navController) }
        composable("email") { EmailScreen(navController) }
    }
    
}