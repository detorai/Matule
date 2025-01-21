package com.example.matulewithstyleguide.ui.sprint_2.catalog

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
import org.koin.androidx.compose.koinViewModel

class CatalogScreen(private val viewModel: SupabaseViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val products = viewModel.products.collectAsState().value
        val categories = viewModel.categories
        val onAdd: (Int) -> Unit = { index ->
            viewModel.onAdd(index) }
        val onFavourite: (Int) -> Unit = { index ->
            viewModel.onFavourite(index) }
        val selectedCategory = viewModel.selectedCategory.collectAsState().value


        LaunchedEffect(Unit) {
            viewModel.countProducts(20)
            Log.d("category:",selectedCategory)
        }
        Catalog(
            onClick = {category ->
                viewModel.selectCategory(category)
            },
            onAdd = onAdd,
            onFavourite = onFavourite,
            onClickBack = {navigator.pop()},
            categories = categories,
            products = products,
            category = selectedCategory
        )
    }
}