package com.example.budgettracker.data.repository

import com.example.budgettracker.data.entity.ExpenseEntry
import kotlinx.coroutines.flow.Flow

interface ExpenseEntryRepository {

    fun getAllEntries(): Flow<List<ExpenseEntry>>

    fun insertEntry(entry: ExpenseEntry)
}
