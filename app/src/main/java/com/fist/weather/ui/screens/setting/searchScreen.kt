package com.fist.weather.ui.screens.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fist.weather.R
import com.fist.weather.ui.screens.setting.components.TopBar

@Composable
fun SettingScreen (
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = { TopBar() }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)

            ) {
                Text(
                    text = stringResource(id = R.string.app_version),
                )
                Text(
                    text = stringResource(id = R.string.app_version_label),
                )
            }
        }
    }
}