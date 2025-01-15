package com.example.matulewithstyleguide

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matulewithstyleguide.data.SupabaseModule
import com.example.matulewithstyleguide.data.repository.AuthRepository
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

    fun signIn() {
        viewModelScope.launch {
            try {
                SupabaseModule.SupabaseClient().auth.signInWith(Email) {
                    email = _emailText.value
                    password = _passwordText.value
                }
                Log.d("SupabaseSignIn", "Success")
            } catch (e: Exception) {
                Log.e("SupabaseSignIn", "HA-HA  ${emailText.value} ${passwordText.value}")
            }
        }
    }
}