package com.example.budgettracker.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.budgettracker.data.DatabaseConstants

@Entity(
    tableName = DatabaseConstants.MONTH_BUDGET_TABLE_NAME,
    primaryKeys = ["month_name", "budget_year"]
)
data class MonthBudget(
    @ColumnInfo(name = "month_name")
    val monthName: String,
    @ColumnInfo(name = "budget_year")
    val budgetYear: Int,
    @ColumnInfo(name = "budget_amount")
    val budgetAmount: String
)