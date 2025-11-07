package com.example.navigastugas

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navigastugas.view.ListPesertaScreen
import com.example.navigastugas.view.WelcomeScreen
import com.example.navigasiku.view.FormulirPendaftaranScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {}
}