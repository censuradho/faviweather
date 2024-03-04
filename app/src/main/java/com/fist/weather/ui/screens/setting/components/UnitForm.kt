package com.fist.weather.ui.screens.setting.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fist.weather.domain.setting.UnitSetting
import com.fist.weather.ui.components.RadioButton

@Composable
fun UnitForm(
    modifier: Modifier = Modifier,
    onChange: (value: String) -> Unit
) {
    Column (

    ) {
        Text(
            text = "Unit",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = modifier
                .padding(16.dp)
        )
        Card(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = modifier.padding(16.dp)
            ) {
                RadioButton(
                    label = "Fahrenheit",
                    onClick = {
                        onChange(UnitSetting.FAHRENHEIT.name)
                    }
                )
    
                RadioButton(
                    label = "Celsius",
                    onClick = {
                        onChange(UnitSetting.CELSIUS.name)
                    }
                )
            }
        }
    }
        
}