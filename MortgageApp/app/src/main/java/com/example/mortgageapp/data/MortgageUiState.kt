package com.example.mortgageapp.data

import kotlin.math.pow

data class MortgageUiState(
    val amount: Double = 100000.00,                 //default value
    val year: MortgageTerms = MortgageTerms.THIRTY, //default value set to thirty
    val apr: Double = 3.5,                          //default value
) {
    //read only monthly calc
    val monthlyPayment: Double
        get() = calculatedMonthly(amount, apr, year)

    //read only total calc
    val totalPayment: Double
        get() = calculateTotal()

    private fun calculatedMonthly(
        amount: Double,
        apr: Double,
        years: MortgageTerms,
    ): Double {
        val mRate = apr / (12 * 100)
        val temp = (1 / (1 + mRate)).pow((years.years * 12).toDouble())
        return "%.2f".format(amount * mRate / (1 - temp)).toDouble()
    }
    private fun calculateTotal(): Double {
        val years = year.years
        val monthlyPayment = monthlyPayment
        return "%.2f".format(monthlyPayment * years * 12).toDouble()
    }
}