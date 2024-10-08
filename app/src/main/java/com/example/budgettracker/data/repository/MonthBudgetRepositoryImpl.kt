package com.example.budgettracker.data.repository

import com.example.budgettracker.data.dao.MonthBudgetDao
import com.example.budgettracker.data.entity.MonthBudget
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MonthBudgetRepositoryImpl @Inject constructor(
    private val monthBudgetDao: MonthBudgetDao
) : MonthBudgetRepository {

    override suspend fun insertMonthEntry(entry: MonthBudget) {
        monthBudgetDao.insertMonthBudget(entry)
    }

    override suspend fun getMonthBudget(month: String, year: Int): Flow<MonthBudget?> {
        return monthBudgetDao.getMonthBudgetByName(month, year)
    }
}