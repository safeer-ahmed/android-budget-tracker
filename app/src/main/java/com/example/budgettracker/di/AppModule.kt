package com.example.budgettracker.di

import android.app.Application
import androidx.room.Room
import com.example.budgettracker.data.BudgetTrackerDatabase
import com.example.budgettracker.data.DatabaseConstants
import com.example.budgettracker.data.repository.ExpenseEntryRepository
import com.example.budgettracker.data.repository.ExpenseEntryRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesBudgetTrackerDatabase(app: Application): BudgetTrackerDatabase {
        return Room.databaseBuilder(
            app,
            BudgetTrackerDatabase::class.java,
            DatabaseConstants.DATABASE_NAME
        ).build()
    }

    @Provides
    fun providesExpenseEntryRepository(
        budgetTrackerDatabase: BudgetTrackerDatabase
    ): ExpenseEntryRepository {
        return ExpenseEntryRepositoryImpl(budgetTrackerDatabase.expenseEntryDao)
    }

}