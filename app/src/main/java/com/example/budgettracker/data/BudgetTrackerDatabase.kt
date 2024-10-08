package com.example.budgettracker.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.budgettracker.data.dao.ExpenseEntryDao
import com.example.budgettracker.data.dao.MonthBudgetDao
import com.example.budgettracker.data.entity.ExpenseEntry
import com.example.budgettracker.data.entity.MonthBudget

@Database(version = 1, entities = [ExpenseEntry::class, MonthBudget::class], exportSchema = false)
@TypeConverters(Converters::class)
abstract class BudgetTrackerDatabase : RoomDatabase() {

    abstract val expenseEntryDao: ExpenseEntryDao
    abstract val monthBudgetDao: MonthBudgetDao

}