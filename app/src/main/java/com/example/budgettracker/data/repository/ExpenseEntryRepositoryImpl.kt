package com.example.budgettracker.data.repository

import com.example.budgettracker.data.dao.ExpenseEntryDao
import com.example.budgettracker.data.entity.ExpenseEntry
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExpenseEntryRepositoryImpl @Inject constructor(
    private val expenseEntryDao: ExpenseEntryDao
) : ExpenseEntryRepository {

    override fun getAllEntries(): Flow<List<ExpenseEntry>> {
        return expenseEntryDao.getAllEntries()
    }

    override fun insertEntry(entry: ExpenseEntry) {
        expenseEntryDao.insertEntry(entry)
    }

}
