package com.example.mortgageapp.data

enum class YearEnum(val years: Int){
    TENYEARS(10) ,
    FIFTEENYEARS (15),
    THIRTYYEARS(30)
}

data class MortgageUiState(
    val amount: Int = 0,
    val year: Int = YearEnum.THIRTYYEARS.years, //default value set to thirty
    val apr: Double = 3.5, //default value for apr
    val monthlyPayment: Double = 0.0,
    val totalPayment: Double = 0.0,
)
