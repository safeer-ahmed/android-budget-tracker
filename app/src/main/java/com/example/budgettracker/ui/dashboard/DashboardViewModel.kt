package com.example.budgettracker.ui.dashboard

import android.icu.util.Calendar
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.budgettracker.data.repository.ExpenseEntryRepository
import com.example.budgettracker.data.repository.MonthBudgetRepository
import com.example.budgettracker.util.Helpers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
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

    private var _dashboardUIState = MutableStateFlow(
        DashboardUIState(
            monthName,
            totalBudget = null,
            totalExpenses = BigDecimal.ZERO,
            remainingBudget = BigDecimal.ZERO
        )
    )
    val dashboardUIState = _dashboardUIState

    init {
        viewModelScope.launch {
            monthBudgetRepository.getMonthBudget(monthName, year).let { monthBudgetFlow ->
                monthBudgetFlow.collect { monthBudget ->
                    Log.e("DashboardViewModel", "month budget: $monthBudget")
                    monthBudget?.let {
                        Log.e("DashboardViewModel", "The amount is: ${it.budgetAmount}")
                        dashboardUIState.value = dashboardUIState.value.copy(
                            totalBudget = it.budgetAmount
                        )
                        updateRemainingBudget()
                    }

                }
            }

            expenseEntryRepository.getAllExpenses().let { it ->
                it.collect { itm ->
                    Log.e("DashboardViewModel", "Expenses: $itm")
                    updateRemainingBudget()
                }
            }
        }
    }

    private fun updateRemainingBudget() {
        dashboardUIState.value.totalBudget?.let { budgetAmount ->
            dashboardUIState.value = dashboardUIState.value.copy(
                remainingBudget = budgetAmount - dashboardUIState.value.totalExpenses
            )
            Log.e("DashboardViewModel", "dashboardUIState: ${dashboardUIState.value}")
        }
    }

}