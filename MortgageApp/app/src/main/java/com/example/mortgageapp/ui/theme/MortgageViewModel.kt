package com.example.mortgageapp.ui.theme

import androidx.lifecycle.ViewModel
import com.example.mortgageapp.data.MortgageTerms
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
            )
        }
    }

    fun setApr(
        apr: Double
    ){
        _uiState.update { currentState ->
            currentState.copy(
                apr = apr,
            )
        }
    }

    fun setYears(
        year: MortgageTerms
    ) {
        _uiState.update { currentState ->
            currentState.copy(
                year = year
            )
        }
    }
}
