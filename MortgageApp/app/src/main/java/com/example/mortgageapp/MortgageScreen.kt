package com.example.mortgageapp

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mortgageapp.ui.theme.MortgageViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mortgage.R
import com.example.mortgageapp.data.DataSource
import com.example.mortgageapp.ui.theme.ModifyScreen
import com.example.mortgageapp.ui.theme.MortgageDisplayScreen

class MortgageScreen {
    enum class MortgageScreen(){
        MortgageDisplayScreen,
        ModifyScreen,
    }

@Composable
fun MortgageApp(
    viewModel: MortgageViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
){
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = MortgageScreen.MortgageDisplayScreen.name,
            modifier = Modifier.padding(16.dp)
        )
        {
            composable(route = MortgageScreen.MortgageDisplayScreen.name){
                MortgageDisplayScreen()
            }
            composable(route = MortgageScreen.ModifyScreen.name){
                ModifyScreen(
                    years = uiState.year,
                    amount = uiState.amount,
                    apr = uiState.apr,
                    onDoneClick = {

                    }
                )
            }
        }
    }

}
