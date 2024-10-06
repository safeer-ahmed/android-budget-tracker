package com.example.budgettracker.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.budgettracker.data.DatabaseConstants
import com.example.budgettracker.data.entity.ExpenseEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseEntryDao {

    @Query("SELECT * FROM ${DatabaseConstants.EXPENSE_ENTRY_TABLE_NAME}")
    fun getAllEntries(): Flow<List<ExpenseEntry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEntry(entry: ExpenseEntry)


}