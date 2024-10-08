package com.example.budgettracker.ui

sealed class Route(val screenName: String) {
    data object Dashboard : Route("dashboard")
    data object SetBudget : Route("set_budget")
    data object AddExpense : Route("add_expense")
}
