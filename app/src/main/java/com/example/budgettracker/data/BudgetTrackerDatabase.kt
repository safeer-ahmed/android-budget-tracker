package com.example.budgettracker.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.budgettracker.data.dao.ExpenseEntryDao
import com.example.budgettracker.data.entity.ExpenseEntry
import com.example.budgettracker.data.entity.MonthBudget

@Database(version = 1, entities = [ExpenseEntry::class, MonthBudget::class], exportSchema = false)
abstract class BudgetTrackerDatabase : RoomDatabase() {

    abstract val expenseEntryDao: ExpenseEntryDao

}