package com.example.mortgageapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mortgage.R
import com.example.mortgageapp.data.MortgageTerms

@Composable
fun MortgageDisplayScreen(
    mortgageTerm: MortgageTerms,
    amount: Double,
    apr: Double,
    modifier: Modifier = Modifier,
    onClickModifyScreen: () -> Unit = {},
    monthlyPayment: Double,
    totalPayment: Double,
){
    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = stringResource(R.string.year),
            )
            Text(
                text = mortgageTerm.years.toString(),
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = stringResource(R.string.loan_amount),
            )
            Text(
                text = "$$amount",
            )


        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = stringResource(R.string.apr),
            )
            Text(
                text = "$apr%",
            )

        }
        Divider(color = Color.Red, thickness = 5.dp)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = stringResource(R.string.monthly_payment),
            )
            Text(
                text = "$$monthlyPayment",
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = stringResource(R.string.total_payment),
            )
            Text(
                text = "$$totalPayment",
            )
        }
        OutlinedButton(
            onClick = onClickModifyScreen,
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Gray,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .padding(32.dp)
                .align(Alignment.CenterHorizontally)

        ) {
            Text(text = stringResource(R.string.modify_data))
        }
    }
}