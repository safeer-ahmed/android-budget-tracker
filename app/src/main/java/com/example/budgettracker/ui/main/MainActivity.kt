package com.example.budgettracker.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.budgettracker.ui.Route
import com.example.budgettracker.ui.addexpense.AddExpenseScreen
import com.example.budgettracker.ui.dashboard.Dashboard
import com.example.budgettracker.ui.dashboard.DashboardViewModel
import com.example.budgettracker.ui.setbudget.SetBudgetScreen
import com.example.budgettracker.ui.setbudget.SetBudgetViewModel
import com.example.budgettracker.ui.theme.BudgetTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BudgetTrackerTheme {
                Scaffold { contentPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(contentPadding)
                    ) {
                        SetupNavigation()
                    }
                }
            }
        }
    }

    @Composable
    fun SetupNavigation() {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = Route.Dashboard.screenName) {
            composable(Route.Dashboard.screenName) {
                DashboardComposable(navController)
            }

            composable(Route.SetBudget.screenName) {
                SetBudgetComposable(navController)
            }

            composable(Route.AddExpense.screenName) {
                AddExpenseScreen()
            }
        }
    }

    @Composable
    fun DashboardComposable(
        navController: androidx.navigation.NavController,
        viewModel: DashboardViewModel = hiltViewModel()
    ) {
        val dashboardUIState by viewModel.dashboardUIState

        Dashboard(
            dashboardUIState = dashboardUIState,
            onBudgetUpdatePressed = {
                navController.navigate(
                    Route.SetBudget.screenName
                )
            },
            onAddExpensePressed = {
                navController.navigate(
                    Route.AddExpense.screenName
                )
            }
        )
    }

    @Composable
    fun SetBudgetComposable(
        navController: androidx.navigation.NavController,
        viewModel: SetBudgetViewModel = hiltViewModel()
    ) {
        val monthBudget by viewModel.monthBudget

        SetBudgetScreen(
            monthBudget = monthBudget,
            onBudgetUpdateClick = { it ->
                viewModel.setBudget(it)
                navController.popBackStack()
            }
        )
    }
}
