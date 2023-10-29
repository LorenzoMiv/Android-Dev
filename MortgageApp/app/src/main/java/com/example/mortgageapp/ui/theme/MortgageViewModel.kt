package com.example.mortgageapp.ui.theme

import androidx.lifecycle.ViewModel
import com.example.mortgageapp.data.MortgageUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MortgageViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(MortgageUiState())
    val uiState: StateFlow<MortgageUiState> = _uiState.asStateFlow()

    fun setAmount(amount: Int, apr: Double, year: Int){
        _uiState.update { currentState ->
            currentState.copy(
                amount = amount,
                apr = apr,
                year = year,
                monthlyPayment = calculateMonthly(apr, years = year),
                totalPayment = calculateTotal(),
            )
        }
    }

    private fun calculateMonthly(
        apr: Double = _uiState.value.apr,
        years: Int = _uiState.value.year): Double {
        val monthlyAmount = 0.0
        val mRate = apr / 12
        val temp = Math.pow((1 / (1 + mRate)), (years * 12).toDouble())
        return monthlyAmount * mRate / (1 - temp).toFloat()
    }

    private fun calculateTotal(
        years: Int = _uiState.value.year,
        monthlyPayment: Double = _uiState.value.monthlyPayment
    ): Double {
        return monthlyPayment * years * 12
    }
}