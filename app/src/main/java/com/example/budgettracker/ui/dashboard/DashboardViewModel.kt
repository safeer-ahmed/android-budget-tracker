package com.example.budgettracker.ui.dashboard

import android.icu.util.Calendar
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.budgettracker.data.repository.ExpenseEntryRepository
import com.example.budgettracker.data.repository.MonthBudgetRepository
import com.example.budgettracker.util.Helpers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val monthBudgetRepository: MonthBudgetRepository,
    private val expenseEntryRepository: ExpenseEntryRepository
) : ViewModel() {

    private val monthName = Helpers.getCurrentMonthName()
    private val year = Calendar.getInstance().get(Calendar.YEAR)

    val dashboardUIState = mutableStateOf(
        DashboardUIState(
            monthName,
            totalBudget = null,
            totalExpenses = BigDecimal.ZERO,
            remainingBudget = BigDecimal.ZERO
        )
    )

    init {
        viewModelScope.launch {
            monthBudgetRepository.getMonthBudget(monthName, year).let { monthBudgetFlow ->
                monthBudgetFlow.collect { monthBudget ->
                    monthBudget?.let {
                        dashboardUIState.value = dashboardUIState.value.copy(
                            totalBudget = it.budgetAmount
                        )
                        updateRemainingBudget()
                    }

                }
            }

            expenseEntryRepository.getAllExpenses().let { it ->
                it.collect { itm ->
                    updateRemainingBudget()
                }
            }
        }
    }

    private fun updateRemainingBudget() {
        dashboardUIState.value.totalBudget?.let { budgetAmount ->
            dashboardUIState.value = dashboardUIState.value.copy(
                remainingBudget = BigDecimal(budgetAmount) - dashboardUIState.value.totalExpenses
            )
        }
    }
}