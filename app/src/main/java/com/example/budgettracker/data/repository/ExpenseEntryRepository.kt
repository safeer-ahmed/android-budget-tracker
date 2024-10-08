package com.example.budgettracker.data.repository

import com.example.budgettracker.data.entity.ExpenseEntry
import kotlinx.coroutines.flow.Flow

interface ExpenseEntryRepository {

    fun insertEntry(entry: ExpenseEntry)

    fun getAllExpenses(): Flow<List<ExpenseEntry>>

}
