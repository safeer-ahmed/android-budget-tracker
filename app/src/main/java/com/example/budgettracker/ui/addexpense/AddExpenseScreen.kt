package com.example.budgettracker.ui.addexpense

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.budgettracker.R
import com.example.budgettracker.ui.commons.NumberInputField
import com.example.budgettracker.ui.commons.TextInputField

@Composable
fun AddExpenseScreen() {

    var expenseName by rememberSaveable { mutableStateOf("") }
    var expenseAmount by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {

        Card(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = stringResource(id = R.string.add_expense),
                    fontSize = 24.sp,
                    color = Color.White
                )

                TextInputField(
                    input = expenseName,
                    hint = stringResource(id = R.string.expense_name),
                    onValueChange = {
                        expenseName = it
                    },
                    onDoneAction = {

                    }
                )

                NumberInputField(
                    input = expenseAmount,
                    onValueChange = {
                        expenseAmount = it
                    },
                    onDoneAction = {

                    }
                )

            }
        }
    }
}

@Preview
@Composable
fun PreviewAddExpenseScreen() {
}