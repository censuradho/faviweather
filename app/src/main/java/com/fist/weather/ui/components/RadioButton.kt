package com.fist.weather.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.compose.material3.RadioButton as MaterialRadioButton

@Composable
fun RadioButton (
    selected: Boolean = false,
    onClick: () -> Unit = {},
    label: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        MaterialRadioButton(
            selected = selected,
            onClick = onClick
        )
        Text(
            text = label,
            fontSize = 14.sp
        )
    }

}