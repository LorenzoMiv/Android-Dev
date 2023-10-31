package com.example.mortgageapp.data

data class MortgageUiState(
    var amount: Double = 0.0,
    var year: Int = 30, //default value set to thirty
    var apr: Double = 0.0, //default value for apr
    var monthlyPayment: Double = 0.0,
    var totalPayment: Double = 0.0,
)
