package com.example.matulewithstyleguide.ui.sprint_2.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.matulewithstyleguide.SupabaseViewModel
import org.koin.androidx.compose.koinViewModel

class HomeScreen: Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = koinViewModel<SupabaseViewModel>()

        val inputText = viewModel.searchText.collectAsState().value
        val state = viewModel.shopState.collectAsState().value
        val categories = viewModel.categories

        Home(
            inputText = inputText,
            onValue = viewModel::onSearchChange,
            state = state,
            onHamburgerClick = {},
            categories = categories,
            onAll = {}
        )
    }
}