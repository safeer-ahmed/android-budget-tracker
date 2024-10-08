package com.example.budgettracker.ui.dashboard

import androidx.compose.runtime.Immutable
import java.math.BigDecimal

@Immutable
data class DashboardUIState(
    val currentMonth: String,
    val totalBudget: BigDecimal?,
    val totalExpenses: BigDecimal,
    val remainingBudget: BigDecimal
)