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
        _uiState.update { currentState ->
            currentState.copy(
                amount = amount,
                //apr = _uiState.value.apr,
                //year = _uiState.value.year,
                //monthlyPayment = calculateMonthly(amount, _uiState.value.apr, _uiState.value.year),
                totalPayment = calculateTotal(),
            )
        }
    }

    fun setApr(
        apr: Double,
    ){
        _uiState.update { currentState ->
            currentState.copy(
                amount = _uiState.value.amount,
                apr = apr,
                year = _uiState.value.year,
                monthlyPayment = calculateMonthly(_uiState.value.amount, apr, _uiState.value.year),
                totalPayment = calculateTotal()
            )
        }
    }

    fun setYears(
        year: Int,
    ) {
        _uiState.update { currentState ->
            currentState.copy(
                amount = _uiState.value.amount,
                apr = _uiState.value.apr,
                year = year,
                monthlyPayment = calculateMonthly(_uiState.value.amount, _uiState.value.apr, year),
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
        val years = _uiState.value.year
        val monthlyPayment = _uiState.value.monthlyPayment
        return monthlyPayment * years * 12
    }
}