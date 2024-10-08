package com.example.budgettracker.ui.commons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.budgettracker.util.Helpers

@Composable
fun NumberInputField(
    onValueChange: (value: String) -> Unit,
    onDoneAction: () -> Unit
) {
    var input by rememberSaveable { mutableStateOf("") }

    TextField(
        value = input,
        onValueChange = { value ->
            // Ensure the input is numeric only
            val decimalCount = value.count { it == '.' }
            if (decimalCount <= 1 && Helpers.isNumeric(value)) {
                input = value
                onValueChange(input)
            }
        },
        label = { Text(text = "Enter a number") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = androidx.compose.ui.text.input.ImeAction.Done,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        keyboardActions = KeyboardActions(
            onDone = {
                onDoneAction()
            }
        )
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewNumberInputField() {
    NumberInputField(
        onValueChange = {},
        onDoneAction = {}
    )
}
