package com.example.budgettracker.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import com.example.budgettracker.data.entity.ExpenseEntry
import com.example.budgettracker.data.entity.MonthBudget
import com.example.budgettracker.data.repository.ExpenseEntryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val expenseEntryRepository: ExpenseEntryRepository
) : ViewModel() {

    fun insertEntry(entry: ExpenseEntry) {
        expenseEntryRepository.insertEntry(entry)
    }

    val monthBudget = MonthBudget(12, "Sep", 450)

}