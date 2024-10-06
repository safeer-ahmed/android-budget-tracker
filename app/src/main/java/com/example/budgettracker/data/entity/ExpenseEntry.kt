package com.example.budgettracker.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.budgettracker.data.DatabaseConstants

@Entity(tableName = DatabaseConstants.EXPENSE_ENTRY_TABLE_NAME)
data class ExpenseEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "entry_name")
    val entryName: String,
    @ColumnInfo(name = "entry_amount")
    val entryAmount: Int
)