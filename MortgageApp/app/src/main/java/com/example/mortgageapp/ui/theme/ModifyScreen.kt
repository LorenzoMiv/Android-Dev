package com.example.mortgageapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mortgage.R
import com.example.mortgageapp.data.DataSource
import com.example.mortgageapp.data.DataSource.years


@Composable
fun ModifyScreen(
    years: Int,
    amount: Int,
    apr: Double,
    onDoneClick: (Double) -> Unit,
    modifier: Modifier = Modifier,
){
    val resources = LocalContext.current.resources

    //val items = listOf(
    //    Pair(stringResource(R.string.year), years),
    //    Pair(stringResource(R.string.amount), amount),
    //    Pair(stringResource(R.string.apr), apr),
    //)

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
    ){
        TextField(
            value = years.toString(),
            onValueChange = {},
            label = { Text(text = stringResource(R.string.year))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
        )
        TextField(
            value = amount.toString(),
            onValueChange = {},
            label = { Text(stringResource(R.string.loan_amount))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
        )
        TextField(
            value = apr.toString(),
            onValueChange = {},
            label = { Text(stringResource(R.string.apr))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            modifier = Modifier
                .fillMaxWidth()
        )
        TextButton(
            onClick = { /*TODO*/ },
            modifier.padding(32.dp),
            shape = RectangleShape,
            //figure out color
        ) {
            Text(text = stringResource(R.string.done))
        }

    }
}

@Preview
@Composable
fun ModScreenPreview(){
    ModifyScreen(
        years = 0,
        amount = 0,
        apr = 3.5,
        onDoneClick = { /*TODO*/ }
    )
}

