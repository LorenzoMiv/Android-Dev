package com.example.mortgageapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mortgageapp.ui.theme.MortgageViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MortgageScreen {
    enum class MortgageScreen(){
        MortgageScreen,
        ModifyScreen,
    }

    @Composable
    fun MortgageApp(
        viewModel: MortgageViewModel = viewModel(),
        navController: NavHostController = rememberNavController(),
        modifier: Modifier = Modifier,
    ){

    }
}