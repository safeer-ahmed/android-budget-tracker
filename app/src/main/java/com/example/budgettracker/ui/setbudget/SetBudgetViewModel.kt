package com.example.budgettracker.ui.setbudget

import android.icu.util.Calendar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.budgettracker.data.entity.MonthBudget
import com.example.budgettracker.data.repository.MonthBudgetRepository
import com.example.budgettracker.util.Helpers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

@HiltViewModel
class SetBudgetViewModel @Inject constructor(
    private val monthBudgetRepository: MonthBudgetRepository
) : ViewModel() {

    private val monthName = Helpers.getCurrentMonthName()
    private val year = Calendar.getInstance().get(Calendar.YEAR)

    fun setBudget(amount: String) {
        viewModelScope.launch {
            monthBudgetRepository.insertMonthEntry(
                MonthBudget(
                    budgetMonth = monthName,
                    budgetYear = year,
                    budgetAmount = BigDecimal(amount)
                )
            )
        }
    }

}