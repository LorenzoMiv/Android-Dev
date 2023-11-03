package com.example.mortgageapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.mortgage.R
import com.example.mortgageapp.data.Apr
import com.example.mortgageapp.data.Money
import com.example.mortgageapp.data.MortgageTerms


@Composable
fun ModifyScreen(
    mortgageTerm: MortgageTerms,
    amount: Double,
    apr: Double,
    onDoneClick: (MortgageTerms, Money, Apr) -> Unit,
    modifier: Modifier = Modifier,
){
    var termValue by rememberSaveable {
        mutableStateOf(mortgageTerm)
    }
    var amountValue by rememberSaveable {
        mutableStateOf(amount.toString())
    }
    var aprValue by rememberSaveable {
        mutableStateOf(apr.toString())
    }

    Column (
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
    ){
        Row(
            horizontalArrangement = SpaceBetween,
            //verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .selectableGroup()
                .fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.year))
            MortgageTerms.values().forEach{
                Column ()
                {
                    val selected = it == termValue
                    val onClick = {termValue = it}
                    RadioButton(selected, onClick)
                    Text(text = it.years.toString())
                }
            }
        }
        TextField(
            value = "$$amountValue",
            onValueChange = {amountValue = it },
            label = { Text( stringResource(R.string.loan_amount))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
        )
        TextField(
            value = "$aprValue%",
            onValueChange = { aprValue = it},
            label = { Text(stringResource(R.string.apr))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier
                .fillMaxWidth()
        )
        OutlinedButton(
            onClick = { onDoneClick(termValue, Money(amountValue), Apr(aprValue)) },
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .padding(32.dp)

            //figure out color
        ) {
            Text(text = stringResource(R.string.done))
        }
    }
}