package com.example.budgettracker.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object Helpers {

    //    TODO: A regex should be used
    fun isNumeric(value: String) = value.all { it.isDigit() || it == '.' }

    fun getCurrentMonthName(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("MMMM", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }
}