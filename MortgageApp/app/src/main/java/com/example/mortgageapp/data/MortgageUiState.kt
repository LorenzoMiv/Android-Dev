package com.example.mortgageapp.data

data class MortgageUiState(
    val amount: Double = 0.0,
    val year: Int = 30, //default value set to thirty
    val apr: Double = 0.0, //default value for apr
    val monthlyPayment: Double = 0.0,
    val totalPayment: Double = 0.0,
)
