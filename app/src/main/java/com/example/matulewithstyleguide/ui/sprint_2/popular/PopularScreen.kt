package com.example.matulewithstyleguide.ui.sprint_2.popular

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.matulewithstyleguide.SupabaseViewModel
import org.koin.androidx.compose.koinViewModel

class PopularScreen: Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = koinViewModel<SupabaseViewModel>()

        val products = viewModel.products.collectAsState().value
        val onAdd: (Int) -> Unit = { index ->
            viewModel.onAdd(index) }
        val onFavourite: (Int) -> Unit = { index ->
            viewModel.onFavourite(index) }

        LaunchedEffect(Unit) {
            viewModel.countProducts(11)
        }

        Popular(
            onFavour = {},
            onAdd = onAdd,
            onFavourite = onFavourite,
            onBack = {navigator.pop()},
            products = products
        )
    }
}