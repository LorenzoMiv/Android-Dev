package com.example.mortgageapp


import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mortgageapp.ui.theme.ModifyScreen
import com.example.mortgageapp.ui.theme.MortgageDisplayScreen
import com.example.mortgageapp.ui.theme.MortgageViewModel
import com.example.mortgage.R

enum class MortgageScreen(@StringRes val title: Int){
    MortgageDisplayScreen(title = R.string.mortgage_info),
    ModifyScreen(title = R.string.modify_data),
}
//needed to import for TopAppBar to work
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MortgageAppBar(
    currentScreen: MortgageScreen,
    modifier: Modifier = Modifier,
){
    TopAppBar(
        title = {Text(stringResource(currentScreen.title))},
        colors = mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {}
    )
}

@Composable
fun MortgageApp(
    viewModel: MortgageViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MortgageScreen.valueOf(
        backStackEntry?.destination?.route ?: MortgageScreen.MortgageDisplayScreen.name
    )
    Scaffold(
        topBar = {
            MortgageAppBar(currentScreen = currentScreen)
        }
    ) {innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navController,
            startDestination = MortgageScreen.MortgageDisplayScreen.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MortgageScreen.MortgageDisplayScreen.name){
                MortgageDisplayScreen(
                    mortgageTerm = uiState.year,
                    amount = uiState.amount,
                    apr = uiState.apr,
                    onClickModifyScreen = {
                        navController.navigate(MortgageScreen.ModifyScreen.name)
                    },
                    monthlyPayment = uiState.monthlyPayment,
                    totalPayment = uiState.totalPayment,
                )
            }
            composable(route = MortgageScreen.ModifyScreen.name){
                ModifyScreen(
                    mortgageTerm = uiState.year,
                    amount = uiState.amount,
                    apr = uiState.apr,
                    onDoneClick = {
                            mortgageTerms, money, apr ->
                        viewModel.setYears(mortgageTerms)
                        viewModel.setAmount(money.value.toDouble())
                        viewModel.setApr(apr.value.toDouble())
                        navController.navigate(MortgageScreen.MortgageDisplayScreen.name)
                    }
                )
            }
        }
    }
}
