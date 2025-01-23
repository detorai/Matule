package com.example.matulewithstyleguide.ui.sprint_4.sign_in

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.matulewithstyleguide.SupabaseViewModel
import com.example.matulewithstyleguide.ui.sprint_4.forgot_password.ForgotPassScreen
import com.example.matulewithstyleguide.ui.sprint_4.sign_up.SignUpScreen

class SignInScreen(private val viewModel: SupabaseViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val emailText = viewModel.emailText.collectAsState().value
        val passwordText = viewModel.passwordText.collectAsState().value
        val viewState = viewModel.viewState.collectAsState().value


        SignIn(
            emailText = emailText,
            onEmailChange = viewModel::onEmailChange,
            passwordText = passwordText,
            onPasswordChange = viewModel::onPasswordChange,
            onButtonClick = {
                viewModel.signIn(
                    email = emailText,
                    password = passwordText
                )
                navigator.push(SignUpScreen(viewModel))
            },
            onClickText = {navigator.push(ForgotPassScreen(viewModel))},
            viewState = viewState,
            viewStateChange = viewModel::viewStateChange,
            onCreate = {navigator.push(SignUpScreen(viewModel))},
            onClickBack = {navigator.pop()}
        )
    }
}