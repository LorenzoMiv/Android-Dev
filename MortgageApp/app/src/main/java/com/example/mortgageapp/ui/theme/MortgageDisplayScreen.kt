package com.example.mortgageapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mortgage.R

@Composable
fun MortgageDisplayScreen(
    years: List<Int>,
    amount: Double,
    apr: Double,
    modifier: Modifier = Modifier,
    onClickModifyScreen: () -> Unit = {},
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
                textAlign = TextAlign.Start
            )
            Text(
                text = years.toString(),
                textAlign = TextAlign.End
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = stringResource(R.string.loan_amount),
                textAlign = TextAlign.Start
            )
            Text(
                text = amount.toString(),
                textAlign = TextAlign.End
            )


        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = stringResource(R.string.apr),
                textAlign = TextAlign.Start
            )
            Text(
                text = apr.toString(),
                textAlign = TextAlign.End
            )

        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = stringResource(R.string.monthly_payment),
                textAlign = TextAlign.Start
            )
            Text(
                text = stringResource(R.string.monthly_payment),
                textAlign = TextAlign.End
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = stringResource(R.string.total_payment),
                textAlign = TextAlign.Start
            )
            Text(
                text = stringResource(R.string.total_payment),
                textAlign = TextAlign.End
            )

        }
        TextButton(
            onClick = onClickModifyScreen,
            shape = RectangleShape,
            modifier = Modifier
                .padding(32.dp)
                .align(Alignment.CenterHorizontally)

        ) {
            Text(text = stringResource(R.string.modify_data))
        }
    }
}

@Preview
@Composable
fun MortgageDisplayScreenPreview(){
    MortgageDisplayScreen(
        years = listOf(10, 15, 30),
        amount = 100000.00,
        apr = 2.5,
        modifier = Modifier
            .fillMaxSize()
    )
}