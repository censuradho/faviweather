package com.fist.weather.ui.screens.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Header (
    modifier: Modifier = Modifier,
    city: String = "",
    country: String = "",
    isFavorite: Boolean = false,
    onLike: () -> Unit = {},
    onUnlike: () -> Unit = {}

) {
    val icon =
        if (isFavorite) Icons.Default.Favorite
        else Icons.Outlined.FavoriteBorder

    val iconLabel =
        if (isFavorite) "Liked"
        else "Like"

    Row(
        modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.LocationOn,
                contentDescription = "Location",
                tint = MaterialTheme.colorScheme.onBackground,
            )
            Text(
                text = city,
                fontWeight = FontWeight.Medium
            )
            Text(text = ", $country", color = MaterialTheme.colorScheme.surfaceTint)
        }
        IconButton(
            onClick = {
                if (isFavorite) onUnlike()
                else onLike()
            }
        ) {
            Icon(
                imageVector = icon,
                contentDescription = iconLabel,
            )
        }
    }
}