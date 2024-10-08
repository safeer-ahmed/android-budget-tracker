package com.example.budgettracker.ui.setbudget

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
import com.example.budgettracker.data.entity.MonthBudget
import com.example.budgettracker.ui.commons.NumberInputField

@Composable
fun SetBudgetScreen(
    onBudgetUpdateClick: (budget: String) -> Unit = {},
    monthBudget: MonthBudget
) {

    var input by rememberSaveable(monthBudget) { mutableStateOf(monthBudget.budgetAmount) }

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
                    text = if (monthBudget.budgetAmount.isNotEmpty())
                        stringResource(
                            id = R.string.update_budget_for,
                            monthBudget.monthName
                        )
                    else stringResource(id = R.string.set_budget_for, monthBudget.monthName),
                    fontSize = 24.sp,
                    color = Color.White
                )

                NumberInputField(
                    input = input,
                    onValueChange = {
                        input = it
                    },
                    onDoneAction = {
                        onBudgetUpdateClick(input)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewSetBudgetScreen() {
    SetBudgetScreen(
        monthBudget = MonthBudget(
            "October", 2023, "200"
        )
    )
}