package com.example.matulewithstyleguide.ui.sprint_4.verification

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.matulewithstyleguide.SupabaseViewModel

class VerificationScreen(private val viewModel: SupabaseViewModel):Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val codeText = viewModel.codeText.map{ it.collectAsState("") }.map { it.value }


        Verification(
            codeText = codeText,
            onCode = viewModel::onCodeChange,
            onClickBack = {navigator.pop()},
            onSend = {}
        )
    }

}