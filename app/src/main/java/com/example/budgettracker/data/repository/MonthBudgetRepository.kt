package com.example.budgettracker.data.repository

import com.example.budgettracker.data.entity.MonthBudget
import kotlinx.coroutines.flow.Flow

interface MonthBudgetRepository {

    suspend fun insertMonthEntry(entry: MonthBudget)

    suspend fun getMonthBudget(month: String, year: Int): Flow<MonthBudget?>

    suspend fun getMonthBudgetOnce(month: String, year: Int): MonthBudget?

}
