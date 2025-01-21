package com.example.matulewithstyleguide.ui.sprint_4.sign_up

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.matulewithstyleguide.SupabaseViewModel

class SignUpScreen(private val viewModel: SupabaseViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val nameText = viewModel.nameTextSU.collectAsState().value
        val emailText = viewModel.emailTextSU.collectAsState().value
        val passwordText = viewModel.passwordTextSU.collectAsState().value
        val viewState = viewModel.viewStateSU.collectAsState().value
        val state = viewModel.checkState.collectAsState().value

        SignUp(
            nameText = nameText,
            onNameChange = viewModel::onNameChangeSU,

            emailText = emailText,
            onEmailChange = viewModel::onEmailChangeSU,

            passwordText = passwordText,
            onPasswordChange = viewModel::onPasswordChangeSU,

            viewState = viewState,
            viewStateChange = viewModel::viewStateChangeSU,

            state = state,
            onCheck = viewModel::onCheckState,

            onClickBack = {navigator.pop()},
            onSignIn = {},
            onButtonClick = {},
            onClickText = {},

        )
    }
}