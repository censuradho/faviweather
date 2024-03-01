package com.fist.weather.ui.screens.search.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import com.fist.weather.ui.components.InputField
import androidx.compose.material.icons.filled.Search as Search1

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchTextField (
    onSearch: (value: String) -> Unit = {}
) {
    var query by remember {
        mutableStateOf(TextFieldValue(""))
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    InputField(
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch(query.text)
                keyboardController?.hide()
            }
        ),
        value = query,
        onValueChange = {
            query = it
        },
        placeholder = "Search",
        leadingIcon = {
            Icon(
                Icons.Default.Search1,
                contentDescription = "Search"
            )
        }
    )
}