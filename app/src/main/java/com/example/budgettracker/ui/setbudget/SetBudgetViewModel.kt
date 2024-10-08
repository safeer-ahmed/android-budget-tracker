package com.example.budgettracker.ui.setbudget

import android.icu.util.Calendar
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.budgettracker.data.entity.MonthBudget
import com.example.budgettracker.data.repository.MonthBudgetRepository
import com.example.budgettracker.util.Helpers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SetBudgetViewModel @Inject constructor(
    private val monthBudgetRepository: MonthBudgetRepository
) : ViewModel() {

    private val monthName = Helpers.getCurrentMonthName()
    private val year = Calendar.getInstance().get(Calendar.YEAR)

    val monthBudget = mutableStateOf(
        MonthBudget(
            monthName,
            year,
            ""
        )
    )

    init {
        viewModelScope.launch {
            monthBudgetRepository.getMonthBudgetOnce(monthName, year).let { it ->
                it?.let {
                    monthBudget.value = it
                }
            }
        }
    }

    fun setBudget(amount: String) {
        viewModelScope.launch {
            monthBudgetRepository.insertMonthEntry(
                MonthBudget(
                    monthName = monthName,
                    budgetYear = year,
                    budgetAmount = amount
                )
            )
        }
    }

}