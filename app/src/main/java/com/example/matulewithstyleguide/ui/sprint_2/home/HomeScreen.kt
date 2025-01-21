package com.example.matulewithstyleguide.ui.sprint_2.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.matulewithstyleguide.SupabaseViewModel
import com.example.matulewithstyleguide.ui.sprint_2.catalog.Catalog
import com.example.matulewithstyleguide.ui.sprint_2.catalog.CatalogScreen
import com.example.matulewithstyleguide.ui.sprint_2.popular.PopularScreen
import org.koin.androidx.compose.koinViewModel

class HomeScreen(private val viewModel: SupabaseViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val inputText = viewModel.searchText.collectAsState().value
        val state = viewModel.shopState.collectAsState().value
        val categories = viewModel.categories
        val products = viewModel.products.collectAsState().value
        val onAdd: (Int) -> Unit = { index ->
            viewModel.onAdd(index) }
        val onFavourite: (Int) -> Unit = { index ->
            viewModel.onFavourite(index) }
        val selectedCategory = viewModel.selectedCategory.collectAsState().value

        LaunchedEffect(Unit) {
            viewModel.countProducts(2)
        }

        Home(
            inputText = inputText,
            onValue = viewModel::onSearchChange,
            state = state,
            onHamburgerClick = {},
            categories = categories,
            onAllFavour = {navigator.push(PopularScreen(viewModel))},
            products = products,
            onAdd = onAdd,
            onFavourite = onFavourite,
            onCart = viewModel::onCart,
            onAllSale = {},
            onClick = {category ->
                viewModel.selectCategory(category)
                navigator.push(CatalogScreen(viewModel))
            }
        )
    }
}