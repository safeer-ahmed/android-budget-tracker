package com.example.budgettracker.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.budgettracker.data.DatabaseConstants
import com.example.budgettracker.data.entity.MonthBudget
import kotlinx.coroutines.flow.Flow

@Dao
interface MonthBudgetDao {

    @Query("SELECT * FROM ${DatabaseConstants.MONTH_BUDGET_TABLE_NAME} where month_name = :monthName AND budget_year=:year limit 1")
    fun getMonthBudgetByName(monthName: String, year: Int): Flow<MonthBudget>

    @Query("SELECT * FROM ${DatabaseConstants.MONTH_BUDGET_TABLE_NAME} where month_name = :monthName AND budget_year=:year limit 1")
    suspend fun getMonthBudgetByNameOnce(monthName: String, year: Int): MonthBudget

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMonthBudget(budget: MonthBudget)

}