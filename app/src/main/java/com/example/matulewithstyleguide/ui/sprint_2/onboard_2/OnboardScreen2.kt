package com.example.matulewithstyleguide.ui.sprint_2.onboard_2

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.matulewithstyleguide.SupabaseViewModel
import com.example.matulewithstyleguide.ui.sprint_2.onboard_3.OnboardScreen3

class OnboardScreen2(private val viewModel: SupabaseViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        Onboard2(
            onClick = {
               navigator.push(OnboardScreen3(viewModel))
            }
        )
    }
}