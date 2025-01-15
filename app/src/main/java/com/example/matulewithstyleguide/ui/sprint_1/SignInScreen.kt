package com.example.matulewithstyleguide.ui.sprint_1

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.matulewithstyleguide.SupabaseViewModel
import org.koin.androidx.compose.koinViewModel

class SignInScreen: Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = koinViewModel<SupabaseViewModel>()

        val emailText = viewModel.emailText.collectAsState().value
        val passwordText = viewModel.passwordText.collectAsState().value
        val viewState = viewModel.viewState.collectAsState().value


        SignIn(
            emailText = emailText,
            onEmailChange = viewModel::onEmailChange,
            passwordText = passwordText,
            onPasswordChange = viewModel::onPasswordChange,
            onButtonClick = {
                viewModel.signIn()
            },
            onClickText = {},
            viewState = viewState,
            viewStateChange = viewModel::viewStateChange
        )
    }
}