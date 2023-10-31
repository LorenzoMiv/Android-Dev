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

    fun setAmount(
        amount: Double
    ){
        uiState.value.amount = amount
        _uiState.update { currentState ->
            currentState.copy(
                amount = uiState.value.amount,
                apr = uiState.value.apr,
                year = uiState.value.year,
                monthlyPayment = calculateMonthly(uiState.value.amount, uiState.value.apr, uiState.value.year),
                totalPayment = calculateTotal(),
            )
        }
    }

    fun setApr(
    ){
        _uiState.update { currentState ->
            currentState.copy(
                amount = uiState.value.amount,
                apr = uiState.value.apr,
                year = uiState.value.year,
                monthlyPayment = calculateMonthly(uiState.value.amount, uiState.value.apr, uiState.value.year),
                totalPayment = calculateTotal()
            )
        }
    }

    fun setYears(
    ) {
        _uiState.update { currentState ->
            currentState.copy(
                amount = uiState.value.amount,
                apr = uiState.value.apr,
                year = uiState.value.year,
                monthlyPayment = calculateMonthly(uiState.value.amount, uiState.value.apr, uiState.value.year),
                totalPayment = calculateTotal()
            )
        }
    }

    private fun calculateMonthly(
        amount: Double,
        apr: Double,
        years: Int
    ): Double {
        val monthlyAmount = amount / years
        val mRate = apr / 12
        val temp = Math.pow((1 / (1 + mRate)), (years * 12).toDouble())
        return monthlyAmount * mRate / (1 - temp).toFloat()
    }

    private fun calculateTotal(
    ): Double {
        val years = uiState.value.year
        val monthlyPayment = uiState.value.monthlyPayment
        return monthlyPayment * years * 12
    }
}