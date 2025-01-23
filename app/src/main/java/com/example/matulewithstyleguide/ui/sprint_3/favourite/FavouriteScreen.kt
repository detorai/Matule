package com.example.matulewithstyleguide.ui.sprint_3.favourite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.matulewithstyleguide.SupabaseViewModel

class FavouriteScreen(private val viewModel: SupabaseViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val products = viewModel.products.collectAsState().value
        val onAdd: (Int) -> Unit = { index ->
            viewModel.onAdd(index) }
        val onFavourite: (Int) -> Unit = { index ->
            viewModel.onFavourite(index) }

        LaunchedEffect(Unit) {
            viewModel.countProducts(11)
        }

        Favourite(
            onFavour = {},
            onAdd = onAdd,
            onFavourite = onFavourite,
            onBack = {navigator.pop()},
            products = products
        )
    }

}