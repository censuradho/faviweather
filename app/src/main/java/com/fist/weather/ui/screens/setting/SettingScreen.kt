package com.fist.weather.ui.screens.setting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.fist.weather.R
import com.fist.weather.ui.screens.setting.components.TopBar
import com.fist.weather.ui.screens.setting.components.UnitForm

@Composable
fun SettingScreen (
    modifier: Modifier = Modifier,
    settingViewModel: SettingViewModel,
) {
    val settings by settingViewModel.uiState.collectAsState()

    if (settings.data !== null) {
        Scaffold(
            topBar = { TopBar() }
        ) { innerPadding ->
            Column(
                modifier = modifier
                    .padding(innerPadding)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Card(
                    modifier = modifier
                        .fillMaxWidth()

                ) {
                    Row (
                        modifier = modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Text(
                            text = stringResource(id = R.string.app_version_label),
                        )
                        Text(
                            text = stringResource(id = R.string.app_version),
                        )
                    }
                }
                UnitForm(
                    onChange = {
                        settingViewModel.handleChangeUnit(it)
                    },
                    value = settings.data!!.unit
                )
            }
        }
    }
}