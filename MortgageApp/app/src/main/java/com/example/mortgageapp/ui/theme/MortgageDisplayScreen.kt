package com.example.mortgageapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mortgage.R

@Composable
fun MortgageDisplayScreen(
    modifier: Modifier = Modifier,
    onClickModifyScreen: () -> Unit = {},
    ){
    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = stringResource(R.string.loan_amount),
            textAlign = TextAlign.Start,
        )
        Text(
            text = stringResource(R.string.year),
            textAlign = TextAlign.Start
        )
        Text(
            text = stringResource(R.string.apr),
            textAlign = TextAlign.Start
        )
        Text(
            text = stringResource(R.string.monthly_payment),
            textAlign = TextAlign.Start
        )
        Text(
            text = stringResource(R.string.total_payment),
            textAlign = TextAlign.Start
        )
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
        modifier = Modifier
            .fillMaxSize()
    )
}