package com.example.budgettracker.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.budgettracker.data.DatabaseConstants

@Entity(tableName = DatabaseConstants.MONTH_BUDGET_TABLE_NAME)
data class MonthBudget(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "month_name")
    val monthName: String,
    @ColumnInfo(name = "month_budget")
    val monthBudget: Int
)