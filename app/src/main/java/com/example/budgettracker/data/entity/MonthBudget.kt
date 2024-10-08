package com.example.budgettracker.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.budgettracker.data.DatabaseConstants
import java.math.BigDecimal

@Entity(
    tableName = DatabaseConstants.MONTH_BUDGET_TABLE_NAME,
    primaryKeys = ["budget_month", "budget_year"]
)
data class MonthBudget(
    @ColumnInfo(name = "budget_month")
    val budgetMonth: String,
    @ColumnInfo(name = "budget_year")
    val budgetYear: Int,
    @ColumnInfo(name = "budget_amount")
    val budgetAmount: BigDecimal
)