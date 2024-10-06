package com.example.budgettracker.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.budgettracker.data.entity.MonthBudget
import com.example.budgettracker.ui.theme.BudgetTrackerTheme

@Composable
fun MainScreen(
    monthBudget: MonthBudget
) {

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding),
            monthBudget
        )
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, budget: MonthBudget) {
    Text(
        text = "Hello $name!, your this month budget is: ${budget.monthBudget}",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BudgetTrackerTheme {
        Greeting("Android", budget = MonthBudget(12, "Test", 123))
    }
}