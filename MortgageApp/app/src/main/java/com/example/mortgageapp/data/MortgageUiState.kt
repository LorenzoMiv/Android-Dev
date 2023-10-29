package com.example.mortgageapp.data

data class MortgageUiState(
    val amount: Int = 0,
    val year: Int = 0, //default value set to thirty
    val apr: Double = 3.5, //default value for apr
    val monthlyPayment: Double = 0.0,
    val totalPayment: Double = 0.0,
)
