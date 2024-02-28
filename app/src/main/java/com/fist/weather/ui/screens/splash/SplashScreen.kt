package com.fist.weather.ui.screens.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.fist.weather.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen (
    modifier: Modifier = Modifier,
    onGoNextScreen: () -> Unit = {}
) {
    val opacity = remember {
        Animatable(0f)
    }

    LaunchedEffect(
        key1 = true,
        block = {
            opacity.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = 10000,
                    easing = {
                       OvershootInterpolator(8f)
                           .getInterpolation(it)
                    }
                )
            )
            delay(1000L)
            onGoNextScreen()
        }
    )

    Column (
        modifier = modifier
            .fillMaxSize()
            .alpha(opacity.value),
        verticalArrangement = Arrangement.spacedBy(
            space = 28.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(R.drawable.weather),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onBackground
        )
        Text(
            text ="Find the sun?",
            style = MaterialTheme.typography.headlineMedium        )
    }
}