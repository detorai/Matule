package com.example.matulewithstyleguide.ui.sprint_4.checkout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.matulewithstyleguide.SupabaseViewModel
import com.example.matulewithstyleguide.ui.sprint_2.home.HomeScreen

class CheckoutScreen(private val viewModel: SupabaseViewModel):Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val emailInfo = viewModel.emailInfo.collectAsState().value
        val phoneInfo = viewModel.phoneInfo.collectAsState().value
        val address = viewModel.addressInfo.collectAsState().value
        val sum = viewModel.sum.collectAsState().value
        val fullSum = viewModel.fullSum.collectAsState().value
        val delivery = viewModel.delivery.collectAsState().value
        val showDialog = viewModel.showDialog.collectAsState().value


        Checkout(
            emailInfo = emailInfo,
            onEmail = {},

            phoneInfo = phoneInfo,
            onPhone = {},

            address = address,
            onAddress = {},

            cardInfo = "",
            onCard = {},

            onClickBack = {navigator.pop()},
            onButtonClick = {
                viewModel.onPopup()
            },
            sum = 753.95,
            deliver = 60.20,
            fullSum = (753.95 + 60.20),
            showDialog = showDialog,
            onPopup = {},
            onBackShop = {
                viewModel.onPopup()
                navigator.push(HomeScreen(viewModel))
            }
        )
    }
}