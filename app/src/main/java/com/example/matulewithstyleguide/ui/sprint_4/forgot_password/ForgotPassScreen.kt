package com.example.matulewithstyleguide.ui.sprint_4.forgot_password

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.matulewithstyleguide.SupabaseViewModel

class ForgotPassScreen(private val viewModel: SupabaseViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val emailText = viewModel.emailTextFP.collectAsState().value
        val showDialog = viewModel.showDialog.collectAsState().value

        ForgotPass(
            emailText = emailText,
            onEmailChange = viewModel::onEmailChangeFP,
            onButtonClick = viewModel::onPopup,
            onClickBack = {navigator.pop()},
            showDialog = showDialog,
            onPopup = {
                viewModel.onPopup()
            }
        )
    }
}