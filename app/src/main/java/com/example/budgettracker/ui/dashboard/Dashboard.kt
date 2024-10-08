package com.example.budgettracker.ui.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.budgettracker.R
import java.math.BigDecimal

@Composable
fun Dashboard(
    dashboardUIState: DashboardUIState,
    onBudgetUpdateClick: () -> Unit
) {

    val context = LocalContext.current

    var isBudgetValid by rememberSaveable { mutableStateOf(false) }
    var budgetText by rememberSaveable() { mutableStateOf("") }
    var remainingBudgetText by rememberSaveable() { mutableStateOf("") }
    var totalExpensesText by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(key1 = dashboardUIState) {
        isBudgetValid = dashboardUIState.totalBudget != null

        budgetText = if (isBudgetValid) "€${dashboardUIState.totalBudget}"
        else context.getString(R.string.set_budget)

        remainingBudgetText = if (isBudgetValid) "€${dashboardUIState.remainingBudget}"
        else "--"

        totalExpensesText = if (isBudgetValid) "€${dashboardUIState.totalExpenses}"
        else "--"
    }

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

                IconButton(
                    modifier = Modifier
                        .align(Alignment.End),
                    onClick = onBudgetUpdateClick
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.add_budget),
                        contentDescription = "Edit"
                    )
                }

                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = "${stringResource(id = R.string.budget_month)} ${dashboardUIState.currentMonth}",
                )
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    text = budgetText,
                    fontSize = 24.sp,
                    color = if (isBudgetValid) Color.White else Color.Red
                )

                Row(modifier = Modifier.padding(top = 24.dp, bottom = 32.dp)) {
                    Column(modifier = Modifier.weight(0.5f)) {
                        Text(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            text = stringResource(id = R.string.remaining_budget),
                        )
                        Text(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            text = remainingBudgetText,
                            fontSize = 24.sp,
                            color = Color.Green
                        )
                    }

                    Column(modifier = Modifier.weight(0.5f)) {
                        Text(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            text = stringResource(id = R.string.spent),
                        )
                        Text(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            text = totalExpensesText,
                            fontSize = 24.sp,
                            color = Color.Red
                        )
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewDashboard() {
    Dashboard(
        DashboardUIState(
            currentMonth = "October",
            totalBudget = BigDecimal(300),
            totalExpenses = BigDecimal(200),
            remainingBudget = BigDecimal(100)
        ),
        onBudgetUpdateClick = {}
    )
}