package com.example.matulewithstyleguide.ui.sprint_2.onboard_1

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.matulewithstyleguide.data.model.ScreenState
import com.example.matulewithstyleguide.ui.sprint_2.onboard_2.OnboardScreen2

class OnboardScreen1: Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Onboard1(
            currentScreen = ScreenState.first,
            onClick = {navigator.push(OnboardScreen2())}
        )
    }
}