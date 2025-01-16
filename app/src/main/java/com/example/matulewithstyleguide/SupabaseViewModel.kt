package com.example.matulewithstyleguide

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matulewithstyleguide.data.SupabaseModule
import com.example.matulewithstyleguide.data.SupabaseModule.client
import com.example.matulewithstyleguide.data.repository.AuthRepository
import com.example.matulewithstyleguide.data.repository.AuthResult
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SupabaseViewModel(private val authRep: AuthRepository): ViewModel() {

    //Sprint 1

    private val _emailText = MutableStateFlow("")
    val emailText = _emailText.asStateFlow()

    private val _passwordText = MutableStateFlow("")
    val passwordText = _passwordText.asStateFlow()

    private val _viewState = MutableStateFlow(false)
    val viewState = _viewState.asStateFlow()

    fun onEmailChange(email: String){
        _emailText.value = email
    }

    fun onPasswordChange(password: String){
        _passwordText.value = password
    }

    fun viewStateChange(){
        _viewState.value = !_viewState.value
    }

    fun signIn(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            when (val result = authRep.signIn(email, password)) {
                is AuthResult.Success -> {
                    Log.d("SupabaseSignIn", "Успешный вход")
                }
                is AuthResult.Failure -> {
                    Log.e("SupabaseSignIn", "Ошибка: ${result.message}")
                }
            }
        }
    }
}